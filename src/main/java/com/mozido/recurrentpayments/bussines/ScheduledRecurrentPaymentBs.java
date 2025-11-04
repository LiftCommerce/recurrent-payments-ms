package com.mozido.recurrentpayments.bussines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.exception.ErrorResponses;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentTransactionStatus;
import com.mozido.recurrentpayments.model.PaymentType;
import com.mozido.recurrentpayments.model.request.*;
import com.mozido.recurrentpayments.model.response.BaseResponse;
import com.mozido.recurrentpayments.model.response.GetMyUserResponse;
import com.mozido.recurrentpayments.model.response.ScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.Filters.ScheduledRecurrentPaymentFilter;
import com.mozido.recurrentpayments.repository.ScheduledRecurrentPaymentFilterRepository;
import com.mozido.recurrentpayments.repository.interfaces.ExecutedScheduledRecurrentPaymentJpaRepository;
import com.mozido.recurrentpayments.repository.interfaces.ScheduledRecurrentPaymentJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.server.ResponseStatusException;

import java.text.ParseException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

@Service
public class ScheduledRecurrentPaymentBs {

    @Value("${fundz.base.url}")
    private String fundzBaseUrl;

    @Value("${v1.tyk.api.key}")
    private String apiKey;

    @Value("${fundz.user.send.money.url}")
    private String fundzUserSendMoneyUrl;

    @Value("${fundz.merchant.payment.M2M.url}")
    private String fundzMerchantPaymentM2MUrl;

    @Value("${fundz.event.url}")
    private String fundzEventUrl;

    @Value("${fundz.event.contribute.url}")
    private String fundzEventContributeUrl;

    private ScheduledRecurrentPaymentFilterRepository scheduledRecurrentPaymentFilterRepository;
    private ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository;
    private ExecutedScheduledRecurrentPaymentJpaRepository executedScheduledRecurrentPaymentJpaRepository;
    private CommonBs commonBs;

    Logger logger = LoggerFactory.getLogger(ScheduledRecurrentPaymentBs.class);


    @Autowired
    public ScheduledRecurrentPaymentBs(ScheduledRecurrentPaymentFilterRepository scheduledRecurrentPaymentFilterRepository,
                                       ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository,
                                       ExecutedScheduledRecurrentPaymentJpaRepository executedScheduledRecurrentPaymentJpaRepository,
                                       CommonBs commonBs
                                       )
    {
        this.scheduledRecurrentPaymentFilterRepository = scheduledRecurrentPaymentFilterRepository;
        this.scheduledRecurrentPaymentJpaRepository = scheduledRecurrentPaymentJpaRepository;
        this.executedScheduledRecurrentPaymentJpaRepository = executedScheduledRecurrentPaymentJpaRepository;
        this.commonBs = commonBs;
    }

    public ScheduledRecurrentPaymentResponse create(MozidoTrxRequest mozidoTrxRequest, ScheduledRecurrentPaymentRequest request) throws Exception {
        ScheduledRecurrentPayment newEntity = new ScheduledRecurrentPayment();
        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        GetMyUserResponse myUserResponse = commonBs.getMyUserInfo(mozidoTrxRequest, null);
        if(myUserResponse != null)
        {
            newEntity.setTenantName(mozidoTrxRequest.getTenantName());
            newEntity.setUserId(myUserResponse.getUser().getUserUUID());
            newEntity.setUsername(myUserResponse.getUser().getUsername());
            newEntity.setSvaId(request.getSvaId());
            newEntity.setBasketId(request.getBasketId());
            newEntity.setCompanyCode(request.getCompanyCode());
            newEntity.setAmount(request.getAmount());
            newEntity.setStartDate(request.getStartDate());
            newEntity.setEndDate(request.getEndDate());
            newEntity.setEndAfter(request.getEndAfter());
            newEntity.setDayOfWeek(request.getDayOfWeek());
            newEntity.setDayOfMonth(request.getDayOfMonth());
            newEntity.setEndAfter(request.getEndAfter());
            newEntity.setType(request.getType());
            newEntity.setPaymentTransactionType(request.getPaymentTransactionType());
            newEntity.setPaymentFrequency(request.getFrequency());
            newEntity.setStatus(request.getStatus());
            newEntity.setCancelUserId(request.getCancelUserId());
            newEntity.setCancelDateTime(request.getCancelDateTime());
            newEntity.setUserAccepted(request.isUserAccepted());
            newEntity.setUserDecline(request.isUserDecline());
            newEntity.setUserSuppressReminders(request.isUserSuppressReminders());
            newEntity.setPendingSenderApproval(request.isPendingSenderApproval());
            newEntity.setLastProcessedDate(request.getLastProcessedDate());
            newEntity.setNotes(request.getNotes());
            newEntity.setCurrencyCode(request.getCurrencyCode());
            ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(newEntity);
            BeanUtils.copyProperties(saved, response);
        }
        else
        {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found");
        }

        return response;
    }

    public ScheduledRecurrentPaymentResponse update(MozidoTrxRequest mozidoTrxRequest, long id, ScheduledRecurrentPaymentRequest request) throws ControllerException, ParseException, JsonProcessingException {

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        GetMyUserResponse myUserResponse = commonBs.getMyUserInfo(mozidoTrxRequest, null);
        if(myUserResponse != null)
        {
            ScheduledRecurrentPayment updatedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));
//        updatedEntity.setTenantName(request.getTenantName());
//        updatedEntity.setUserId(request.getUserId());
//        updatedEntity.setUsername(request.getUsername());
//        updatedEntity.setSvaId(request.getSvaId());
//        updatedEntity.setBasketId(request.getBasketId());
//        updatedEntity.setCompanyCode(request.getCompanyCode());
//        updatedEntity.setAmount(request.getAmount());
//        updatedEntity.setStartDate(request.getStartDate());
//        updatedEntity.setEndDate(request.getEndDate());
//        updatedEntity.setEndAfter(request.getEndAfter());
//          updatedEntity.setDayOfWeek(request.getDayOfWeek());
//          updatedEntity.setDayOfMonth(request.getDayOfMonth());
//        updatedEntity.setType(request.getType());
//        updatedEntity.setPaymentTransactionType(request.getPaymentTransactionType());
//        updatedEntity.setPaymentFrequency(request.getPaymentFrequency());
          updatedEntity.setStatus(request.getStatus());
//        updatedEntity.setCancelUserId(request.getCancelUserId());
//        updatedEntity.setCancelDateTime(request.getCancelDateTime());
//        updatedEntity.setUserAccepted(request.isUserAccepted());
//        updatedEntity.setUserDecline(request.isUserDecline());
//        updatedEntity.setUserSuppressReminders(request.isUserSuppressReminders());
//        updatedEntity.setPendingSenderApproval(request.isPendingSenderApproval());
//        updatedEntity.setLastProcessedDate(request.getLastProcessedDate());
//        updatedEntity.setNotes(request.getNotes());
//        updatedEntity.setCurrencyCode(request.getCurrencyCode());
          ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(updatedEntity);
          BeanUtils.copyProperties(saved, response);
        }
        else
        {
             throw new ResponseStatusException(HttpStatus.NOT_FOUND, "User not Found");
        }
        return response;
    }

    public ScheduledRecurrentPaymentResponse get(MozidoTrxRequest mozidoTrxRequest, long id) {
        ScheduledRecurrentPayment savedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
        response.setId(savedEntity.getId());
        response.setTenantName(savedEntity.getTenantName());
        response.setUserId(savedEntity.getUserId());
        response.setUsername(savedEntity.getUsername());
        response.setSvaId(savedEntity.getSvaId());
        response.setBasketId(savedEntity.getBasketId());
        response.setCompanyCode(savedEntity.getCompanyCode());
        response.setAmount(savedEntity.getAmount());
        response.setStartDate(savedEntity.getStartDate());
        response.setEndDate(savedEntity.getEndDate());
        response.setEndAfter(savedEntity.getEndAfter());
        response.setDayOfWeek(savedEntity.getDayOfWeek());
        response.setDayOfMonth(savedEntity.getDayOfMonth());
        response.setType(savedEntity.getType());
        response.setPaymentTransactionType(savedEntity.getPaymentTransactionType());
        response.setPaymentFrequency(savedEntity.getPaymentFrequency());
        response.setStatus(savedEntity.getStatus());
        response.setCancelUserId(savedEntity.getCancelUserId());
        response.setCancelDateTime(savedEntity.getCancelDateTime());
        response.setUserAccepted(savedEntity.isUserAccepted());
        response.setUserDecline(savedEntity.isUserDecline());
        response.setUserSuppressReminders(savedEntity.isUserSuppressReminders());
        response.setPendingSenderApproval(savedEntity.isPendingSenderApproval());
        response.setLastProcessedDate(savedEntity.getLastProcessedDate());
        response.setNotes(savedEntity.getNotes());
        response.setCurrencyCode(savedEntity.getCurrencyCode());
        return response;
    }

    public Page<ScheduledRecurrentPayment> findByFilters(ScheduledRecurrentPaymentFilter filter, Pageable pageable) {
        return scheduledRecurrentPaymentFilterRepository.findByFilters(filter, pageable);
    }



    public void processDuePayments(LocalDate today) throws ControllerException {
        List<ScheduledRecurrentPayment> activePayments = scheduledRecurrentPaymentJpaRepository.findAllActive();
        for (ScheduledRecurrentPayment payment : activePayments)
        {
            ExecutedScheduledRecurrentPayment executedPayment = new ExecutedScheduledRecurrentPayment();
            if (shouldExecuteToday(payment))
            {
                String token = commonBs.getToken(payment.getTenantName(),payment.getTenantName());

                executedPayment.setScheduledRecurrentPayment(payment);
                executedPayment.setExecutionDate(LocalDate.now());
                executedPayment.setRetries(1);
                executedPayment.setSuccess(true);
                executedPayment.setTransactionStatus(PaymentTransactionStatus.UP);
                try
                {
                    payment.setLastProcessedDate(today);
                    ContributeToEventRequest contributeRequest = new ContributeToEventRequest();
                    contributeRequest.setId(Long.valueOf(payment.getSvaId()));
                    contributeRequest.setSvaId(payment.getSvaId());
                    contributeRequest.setAmount(payment.getAmount());
                    contributeRequest.setTenantName(payment.getTenantName());
                    contributeRequest.setToken(token);
                    contributeToEvent(contributeRequest, null, null, null, null);

                }
                catch (Exception e)
                {
                    executedPayment.setSuccess(false);
                    executedPayment.setErrorMessage(e.getMessage());
                    executedPayment.setTransactionStatus(PaymentTransactionStatus.DOWN);
                }
                finally
                {
                    scheduledRecurrentPaymentJpaRepository.save(payment);
                    executedScheduledRecurrentPaymentJpaRepository.save(executedPayment);
                }
            }
        }
    }

    private boolean shouldExecuteToday(ScheduledRecurrentPayment p) {

        LocalDate today = LocalDate.now();

        if (p.getLastProcessedDate() != null && p.getLastProcessedDate().isEqual(today)) {
            return false;
        }

        if (p.getStartDate().isAfter(today)) {
            return false;
        }

        switch (p.getPaymentFrequency()) {
            case WEEKLY:
                return today.getDayOfWeek() == p.getDayOfWeek();

            case BIWEEKLY:
                long weeksSinceStart = ChronoUnit.WEEKS.between(p.getStartDate(), today);
                return weeksSinceStart % 2 == 0 && today.getDayOfWeek() == p.getDayOfWeek();

            case MONTHLY:
                return today.getDayOfMonth() == p.getDayOfMonth();

            case YEARLY:
                return today.getMonth() == p.getStartDate().getMonth()
                        && today.getDayOfMonth() == p.getStartDate().getDayOfMonth();

            default:
                return false;
        }

    }

    private BaseResponse sendP2P(String tenantName, String token, ScheduledRecurrentPayment payment) throws ControllerException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", token);
        headers.add("TenantName", tenantName);
        headers.add("api-key", apiKey);

        headers.add("P2P", "P2P");

        // PersonToPerson request creation
        PersonToPersonRequest request = new PersonToPersonRequest();
        request.setAmount(payment.getAmount());
        request.setCurrencyCode(payment.getCurrencyCode());
        request.setUsername(payment.getUsername());
        request.setSubject("Automatic Payment P2P");
        request.setSvaId(payment.getSvaId());
        request.setTenantName(payment.getTenantName());

        HttpEntity requestEntity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        try
        {
            ResponseEntity<BaseResponse> response = restTemplate.exchange(fundzBaseUrl + fundzUserSendMoneyUrl, HttpMethod.POST, requestEntity, BaseResponse.class);
            logger.info("p2p: " + response.getBody());
            return response.getBody();
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
    }

    private BaseResponse sendP2M(String tenantName, String token, ScheduledRecurrentPayment payment) throws ControllerException {
        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", token);
        headers.add("TenantName", tenantName);
        headers.add("api-key", apiKey);

        RestTemplate restTemplate = new RestTemplate();

        // PersonToMerchant request creation
        PersonToMerchantRequest request = new PersonToMerchantRequest();
        request.setAmount(payment.getAmount());
        request.setCurrencyCode(payment.getCurrencyCode());
        request.setCompanyCode(payment.getCompanyCode());
        request.setSubject("Automatic Payment P2M");
        request.setIsM2MTransfer(true);
        request.setTenantName(payment.getTenantName());
        request.setContainerId(payment.getSvaId());

        HttpEntity requestEntity = new HttpEntity<>(request, headers);

        try
        {
            ResponseEntity<BaseResponse> response = restTemplate.exchange(fundzBaseUrl + fundzMerchantPaymentM2MUrl , HttpMethod.POST, requestEntity, BaseResponse.class);
            logger.info("sendP2M: " + response.getBody());
            return response.getBody();
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
    }

    public BaseResponse contributeToEvent(ContributeToEventRequest request, String deviceId, String timeZone, String deviceOs, String ipAdd) throws ControllerException {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("Authorization", request.getToken());
        headers.add("TenantName", request.getTenantName());
        headers.add("api-key", apiKey);

        if (null != deviceId) {
            headers.add("DEVICE_ID", deviceId);
        }
        if (null != timeZone) {
            headers.add("TIMEZONE", timeZone);
        }
        if (null != deviceOs) {
            headers.add("DEVICE_OS", deviceOs);
        }
        if (null != ipAdd) {
            headers.add("x-forwarded-for", String.valueOf(ipAdd));
        }

        HttpEntity requestEntity = new HttpEntity<>(request, headers);

        RestTemplate restTemplate = new RestTemplate();
        try {
            ResponseEntity<BaseResponse> response = restTemplate.exchange(fundzBaseUrl + fundzEventUrl + fundzEventContributeUrl, HttpMethod.POST, requestEntity, BaseResponse.class);
            logger.info("contributeToEvent: " + response.getBody());
            return response.getBody();
        } catch (Exception e) {
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
    }
}
