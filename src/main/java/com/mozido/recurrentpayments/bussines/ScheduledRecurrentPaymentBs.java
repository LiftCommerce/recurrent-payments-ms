package com.mozido.recurrentpayments.bussines;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.exception.ErrorResponses;
import com.mozido.recurrentpayments.model.PaymentFrequency;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentTransactionStatus;
import com.mozido.recurrentpayments.model.request.*;
import com.mozido.recurrentpayments.model.response.ApiResponse;
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
import java.time.temporal.TemporalAdjusters;
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

    private final String CATHOLIC_TENANT = "RCC";

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

    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> create(MozidoTrxRequest mozidoTrxRequest, ScheduledRecurrentPaymentRequest request) throws Exception {
        ScheduledRecurrentPayment newEntity = new ScheduledRecurrentPayment();
        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();

          GetMyUserResponse myUserResponse = commonBs.getMyUserInfo(mozidoTrxRequest, null);
            if(myUserResponse != null)
            {
                if (request.getStartDate().isBefore(LocalDate.now()))
                {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(ApiResponse.error(400, "Start date cannot be before today"));
                }
                else
                {
                    newEntity.setTenantName(mozidoTrxRequest.getTenantName());
                    newEntity.setUserId(myUserResponse.getUser().getUserUUID());
                    newEntity.setUsername(myUserResponse.getUser().getUsername());
                    newEntity.setSvaId(request.getSvaId());
                    newEntity.setBasketId(request.getBasketId());
                    newEntity.setBasketName(request.getBasketName());
                    newEntity.setCompanyCode(request.getCompanyCode());
                    newEntity.setCompanyName(request.getCompanyName());
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
                    newEntity.setNextOccurrenceDate(calculateNextOccurrenceDate(newEntity));
                    ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(newEntity);
                    BeanUtils.copyProperties(saved, response);

                    if(request.getFrequency().equals(PaymentFrequency.DAILY) && !request.isDeferToNextOccurrence())
                    {
                        ExecutedScheduledRecurrentPayment executedPayment = new ExecutedScheduledRecurrentPayment();
                        {
                            LocalDate today = LocalDate.now();
                            executedPayment.setScheduledRecurrentPayment(saved);
                            executedPayment.setExecutionDate(LocalDate.now());
                            executedPayment.setRetries(1);
                            executedPayment.setSuccess(true);
                            executedPayment.setTransactionStatus(PaymentTransactionStatus.UP);
                            try
                            {
                                saved.setLastProcessedDate(today);
                                ContributeToEventRequest contributeRequest = new ContributeToEventRequest();
                                contributeRequest.setId(Long.valueOf(saved.getSvaId()));
                                contributeRequest.setSvaId(saved.getSvaId());
                                contributeRequest.setAmount(saved.getAmount());
                                contributeRequest.setTenantName(saved.getTenantName());
                                contributeRequest.setToken(mozidoTrxRequest.getToken());
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
                                scheduledRecurrentPaymentJpaRepository.save(saved);
                                executedScheduledRecurrentPaymentJpaRepository.save(executedPayment);
                            }
                        }
                    }
                }
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "User not Found"));
            }

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> update(MozidoTrxRequest mozidoTrxRequest, long id, ScheduledRecurrentPaymentRequest request) throws ControllerException, ParseException, JsonProcessingException {

        ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();

            GetMyUserResponse myUserResponse = commonBs.getMyUserInfo(mozidoTrxRequest, null);
            if(myUserResponse != null)
            {
                ScheduledRecurrentPayment updatedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

                if(! updatedEntity.getStatus().equals(PaymentStatus.CANCELED))
                {
                    updatedEntity.setStatus(request.getStatus());
                    ScheduledRecurrentPayment saved = scheduledRecurrentPaymentJpaRepository.save(updatedEntity);
                    BeanUtils.copyProperties(saved, response);
                }
                else
                {
                    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                            .body(ApiResponse.error(400, "Recurrent Payment is in CANCELED status"));
                }
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "User not Found"));
            }

        return ResponseEntity.ok(ApiResponse.success(response));
    }

    public ResponseEntity<ApiResponse<ScheduledRecurrentPaymentResponse>> get(MozidoTrxRequest mozidoTrxRequest, long id) throws ControllerException, ParseException, JsonProcessingException {


            GetMyUserResponse myUserResponse = commonBs.getMyUserInfo(mozidoTrxRequest, null);
            if(myUserResponse != null)
            {

                ScheduledRecurrentPayment savedEntity = scheduledRecurrentPaymentJpaRepository.findById(id)
                        .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

                ScheduledRecurrentPaymentResponse response = new ScheduledRecurrentPaymentResponse();
                response.setId(savedEntity.getId());
                response.setTenantName(savedEntity.getTenantName());
                response.setUserId(savedEntity.getUserId());
                response.setUsername(savedEntity.getUsername());
                response.setSvaId(savedEntity.getSvaId());
                response.setBasketId(savedEntity.getBasketId());
                response.setBasketName(savedEntity.getBasketName());
                response.setCompanyCode(savedEntity.getCompanyCode());
                response.setCompanyName(savedEntity.getCompanyName());
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
                response.setNextOccurrenceDate(savedEntity.getNextOccurrenceDate());
                response.setNotes(savedEntity.getNotes());
                response.setCurrencyCode(savedEntity.getCurrencyCode());
                return ResponseEntity.ok(ApiResponse.success(response));
            }
            else
            {
                return ResponseEntity.status(HttpStatus.NOT_FOUND)
                        .body(ApiResponse.error(404, "User not Found"));
            }

    }

    public Page<ScheduledRecurrentPayment> findByFilters(MozidoTrxRequest mozidoTrxRequest, ScheduledRecurrentPaymentFilter filter, Pageable pageable) {
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
                    LocalDate next = calculateNextOccurrenceDate(payment);
                    payment.setNextOccurrenceDate(next);

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
        return LocalDate.now().isEqual(p.getNextOccurrenceDate());
    }

    public LocalDate calculateNextOccurrenceDate(ScheduledRecurrentPayment p) {

        LocalDate today = LocalDate.now();
        LocalDate start = p.getStartDate();
        LocalDate lastProcessed = p.getLastProcessedDate();

        LocalDate baseDate;
        if (lastProcessed == null)
        {
            if (today.isBefore(start))
            {
                return start;
            }

            baseDate = start;
        }
        else
        {
            baseDate = lastProcessed;
        }

        switch (p.getPaymentFrequency())
        {
            case DAILY:
                return baseDate.plusDays(1);

            case WEEKLY:
                return baseDate.with(TemporalAdjusters.next(p.getDayOfWeek()));

            case BIWEEKLY:
                LocalDate nextWeekly = baseDate.with(TemporalAdjusters.next(p.getDayOfWeek()));
                return nextWeekly.plusWeeks(1);

            case MONTHLY:
                Integer dom = p.getDayOfMonth();
                if (dom == null) {
                    throw new IllegalStateException("dayOfMonth can't be null for MONTHLY Frequency");
                }

                LocalDate nextMonth = baseDate.plusMonths(1);

                int lastDay = nextMonth.lengthOfMonth();
                int day = Math.min(dom, lastDay);

                return nextMonth.withDayOfMonth(day);

            case YEARLY:
                LocalDate sd = p.getStartDate();
                if (sd == null) {
                    throw new IllegalStateException("startDate can't be null for YEARLY");
                }

                return baseDate.plusYears(1)
                        .withMonth(sd.getMonthValue())
                        .withDayOfMonth(sd.getDayOfMonth());

            default:
                throw new IllegalArgumentException("Frequency not supported: " + p.getPaymentFrequency());
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
