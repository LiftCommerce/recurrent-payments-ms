package com.mozido.recurrentpayments.bussines;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.request.ExecutedScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.request.MozidoTrxRequest;
import com.mozido.recurrentpayments.model.response.ExecutedScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.ExecutedScheduledRecurrentPaymentFilterRepository;
import com.mozido.recurrentpayments.repository.Filters.ExecutedScheduledRecurrentPaymentFilter;
import com.mozido.recurrentpayments.repository.interfaces.ExecutedScheduledRecurrentPaymentJpaRepository;
import com.mozido.recurrentpayments.repository.interfaces.ScheduledRecurrentPaymentJpaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ExecutedScheduledRecurrentPaymentBs {

    private ExecutedScheduledRecurrentPaymentFilterRepository executedScheduledRecurrentPaymentFilterRepository;
    private ExecutedScheduledRecurrentPaymentJpaRepository executedScheduledRecurrentPaymentJpaRepository;
    private ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository;

    public ExecutedScheduledRecurrentPaymentBs()
    {
    }

    @Autowired
    public ExecutedScheduledRecurrentPaymentBs(ScheduledRecurrentPaymentJpaRepository scheduledRecurrentPaymentJpaRepository,
                                               ExecutedScheduledRecurrentPaymentFilterRepository executedScheduledRecurrentPaymentFilterRepository,
                                               ExecutedScheduledRecurrentPaymentJpaRepository executedScheduledRecurrentPaymentJpaRepository)
    {
        this.scheduledRecurrentPaymentJpaRepository = scheduledRecurrentPaymentJpaRepository;
        this.executedScheduledRecurrentPaymentFilterRepository = executedScheduledRecurrentPaymentFilterRepository;
        this.executedScheduledRecurrentPaymentJpaRepository = executedScheduledRecurrentPaymentJpaRepository;
    }

    public ExecutedScheduledRecurrentPaymentResponse create(ExecutedScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment scheduled = scheduledRecurrentPaymentJpaRepository.findById(request.getScheduledRecurrentPaymentId())
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

        ExecutedScheduledRecurrentPayment newEntity = new ExecutedScheduledRecurrentPayment();
        newEntity.setScheduledRecurrentPayment(scheduled);
        newEntity.setExecutionDate(request.getExecutionDate());
        newEntity.setSuccess(request.isSuccess());
        newEntity.setRetries(request.getRetries());
        newEntity.setTransactionStatus(request.getTransactionStatus());
        newEntity.setErrorMessage(request.getErrorMessage());

        ExecutedScheduledRecurrentPayment saved = executedScheduledRecurrentPaymentJpaRepository.save(newEntity);

        ExecutedScheduledRecurrentPaymentResponse response = new ExecutedScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ExecutedScheduledRecurrentPaymentResponse update(long id, ExecutedScheduledRecurrentPaymentRequest request) {
        ExecutedScheduledRecurrentPayment entity = executedScheduledRecurrentPaymentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExecutedScheduledRecurrentPayment not found"));

        ScheduledRecurrentPayment scheduled = scheduledRecurrentPaymentJpaRepository.findById(request.getScheduledRecurrentPaymentId())
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

        entity.setScheduledRecurrentPayment(scheduled);
        entity.setExecutionDate(request.getExecutionDate());
        entity.setSuccess(request.isSuccess());
        entity.setRetries(request.getRetries());
        entity.setTransactionStatus(request.getTransactionStatus());
        entity.setErrorMessage(request.getErrorMessage());

        ExecutedScheduledRecurrentPayment saved = executedScheduledRecurrentPaymentJpaRepository.save(entity);

        ExecutedScheduledRecurrentPaymentResponse response = new ExecutedScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        return response;
    }

    public ExecutedScheduledRecurrentPaymentResponse get(MozidoTrxRequest mozidoTrxRequest, long id) {
        ExecutedScheduledRecurrentPayment savedEntity = executedScheduledRecurrentPaymentJpaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExecutedScheduledRecurrentPaymentRepository not found"));
        ExecutedScheduledRecurrentPaymentResponse response = new ExecutedScheduledRecurrentPaymentResponse();
        response.setId(savedEntity.getId());
        response.setScheduledRecurrentPaymentId(savedEntity.getScheduledRecurrentPayment().getId());
        response.setExecutionDate(savedEntity.getExecutionDate());
        response.setSuccess(savedEntity.isSuccess());
        response.setRetries(savedEntity.getRetries());
        response.setTransactionStatus(savedEntity.getTransactionStatus());
        response.setErrorMessage(savedEntity.getErrorMessage());
        return response;
    }

    public Page<ExecutedScheduledRecurrentPayment> getByFilters(
            ExecutedScheduledRecurrentPaymentFilter filter,
            Pageable pageable) {
        return executedScheduledRecurrentPaymentFilterRepository.findByFilters(filter, pageable);
    }

}
