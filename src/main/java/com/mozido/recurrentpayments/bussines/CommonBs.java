package com.mozido.recurrentpayments.bussines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozido.recurrentpayments.entity.Setting;
import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.exception.ErrorResponses;
import com.mozido.recurrentpayments.model.Language;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.response.GetMyUserResponse;
import com.mozido.recurrentpayments.model.response.OauthTokenResponse;
import com.mozido.recurrentpayments.repository.interfaces.SettingJpaRepository;
import org.apache.http.entity.ContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.text.ParseException;
import java.time.Instant;
import java.util.Arrays;
import java.util.Optional;

import static com.mozido.recurrentpayments.exception.ErrorResponses.TENANT_SETTING_NOT_EXIST;

@Component
public class CommonBs
{
    @Value("${v1.mozido.switch.oauth.internal.url}")
    private String authInternalUrl;

    @Value("${v1.tyk.api.key.name}")
    private String tykApiKeyName;

    @Value("${v1.tyk.api.key.value}")
    private String tykApiKeyValue;

    @Value("${fundz.base.url}")
    private String fundzBaseUrl;

    @Value("${fundz.user.get.my.user.info.url}")
    private String fundzUserGetMyUserInfoUrl;

    @Value("${v1.tyk.api.key}")
    private String apiKey;

    @Value("${environment}")
    private String environment;

    private SettingJpaRepository settingJpaRepository;

    Logger logger = LoggerFactory.getLogger(CommonBs.class);

    @Autowired
    public CommonBs(SettingJpaRepository settingJpaRepository)
    {
        this.settingJpaRepository = settingJpaRepository;
    }

    public String getToken(String tenantName, String interfaceName) throws ControllerException {

        Optional<Setting> optSetting = settingJpaRepository.findOneByTenantNameAndInterfaceName(tenantName, interfaceName);
        if (!optSetting.isPresent())
        {
            throw new ControllerException(TENANT_SETTING_NOT_EXIST, Language.ENGLISH);
        }

        Setting setting = optSetting.get();
        if (null != setting.getLastSignOn())
        {
            Instant instant = Instant.now();
            long timeStampSeconds = instant.getEpochSecond();
            Long tokenExpiryTime = setting.getTokenExpiresAtSeconds() != null ? setting.getTokenExpiresAtSeconds() : 0;
            if ((timeStampSeconds + 3) < tokenExpiryTime) {
                logger.info("Token has not expired");
                return setting.getToken();
            }
            else
            {
                logger.info("Token has expired.. getting new token");
                return this.obtainToken(setting);
            }
        }
        else
        {
            if (setting.getIsEncrypted())
            {
                setting.decrypt();
                return this.obtainToken(setting);
            }
            else
            {
                String token = this.obtainToken(setting);
                setting.encrypt();
                settingJpaRepository.saveAndFlush(setting);
                return token;
            }
        }
    }

    public String obtainToken(Setting setting) {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Content-Type", ContentType.APPLICATION_FORM_URLENCODED.getMimeType());
        headers.add(tykApiKeyName, tykApiKeyValue);
        headers.add("tenantName", setting.getTenantName());
        if (setting.getIsEncrypted())
            setting.decrypt();

        String body = "grant_type=password&username=" + (setting.getUsername()) +
                "&password=" + (setting.getPassword());

        HttpEntity<String> httpRequest = new HttpEntity<>(body, headers);

        try
        {
            ResponseEntity<OauthTokenResponse> response = null;
            RestTemplate restTemplate = new RestTemplate();
            logger.info("------------------/////////////////////////-------------------" + body );
            logger.info("URL: " + authInternalUrl);
            try
            {
                response = restTemplate.postForEntity(authInternalUrl, httpRequest, OauthTokenResponse.class);

            }
            catch (Exception e)
            {
                logger.info(e.toString());
            }

            setting.setLastSignOn(response.getBody().getLastSignonTimestamp());
            setting.setExpiresIn(response.getBody().getExpiresIn());
            setting.setToken(response.getBody().getAccessToken());
            setting.setRefreshToken(response.getBody().getRefreshToken());
            setting.setTokenExpiresAtSeconds(Instant.now().getEpochSecond() + response.getBody().getExpiresIn());
            settingJpaRepository.saveAndFlush(setting);

            return response.getBody().getAccessToken();
        }
        catch (Exception e)
        {
            e.printStackTrace();
            return null;
        }
    }

    public GetMyUserResponse getMyUserInfo(MozidoTrxRequest request, String companyId) throws ControllerException, ParseException, JsonProcessingException {
        HttpHeaders headers = new HttpHeaders();
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        GetMyUserResponse getMyUserResponse = new GetMyUserResponse();
        headers.add("Authorization", request.getToken());
        headers.add("tenantName", request.getTenantName());
        //headers.add("api-key", apiKey);
        //headers.add("environment", environment);

        HttpEntity requestEntity = new HttpEntity<>(request, headers);

        if (null != companyId) {
            headers.add("companyId", companyId);
        }

        try
        {
            RestTemplate restTemplate = new RestTemplate();
            ResponseEntity<GetMyUserResponse> response = restTemplate.exchange(fundzBaseUrl + fundzUserGetMyUserInfoUrl, HttpMethod.GET,
                    requestEntity, GetMyUserResponse.class);
            getMyUserResponse = response.getBody();
        }
        catch (Exception e)
        {
            if (e instanceof ControllerException) {
                throw e;
            }
            if (e instanceof RestClientException) {
                ErrorResponses errorResponses =  new ErrorResponses(HttpStatus.valueOf(500),
                        500,((RestClientException) e).getMessage());
                throw new ControllerException(e.getMessage(), errorResponses);
            }
            if(e instanceof HttpClientErrorException)
            {
                ErrorResponses errorResponses =  new ErrorResponses((HttpStatus) ((HttpClientErrorException) e).getStatusCode(),
                        ((HttpClientErrorException) e).getRawStatusCode(),((HttpClientErrorException) e).getMessage());
                throw new ControllerException(((HttpClientErrorException) e).getMessage(), errorResponses);
            }
            e.printStackTrace();
            return null;
        }
        return getMyUserResponse;
    }
}
