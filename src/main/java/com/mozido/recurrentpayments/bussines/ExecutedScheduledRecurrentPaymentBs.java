package com.mozido.recurrentpayments.bussines;

import com.mozido.recurrentpayments.entity.ExecutedScheduledRecurrentPayment;
import com.mozido.recurrentpayments.entity.ScheduledRecurrentPayment;
import com.mozido.recurrentpayments.model.request.ExecutedScheduledRecurrentPaymentRequest;
import com.mozido.recurrentpayments.model.response.ExecutedScheduledRecurrentPaymentResponse;
import com.mozido.recurrentpayments.repository.ExecutedScheduledRecurrentPaymentRepository;
import com.mozido.recurrentpayments.repository.ScheduledRecurrentPaymentRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ExecutedScheduledRecurrentPaymentBs {

    private ExecutedScheduledRecurrentPaymentRepository executedScheduledRecurrentPaymentRepository;

    private ScheduledRecurrentPaymentRepository scheduledRecurrentPaymentRepository;

    @Autowired
    public ExecutedScheduledRecurrentPaymentBs(ScheduledRecurrentPaymentRepository scheduledRecurrentPaymentRepository,
                                               ExecutedScheduledRecurrentPaymentRepository executedScheduledRecurrentPaymentRepository)
    {
        this.scheduledRecurrentPaymentRepository = scheduledRecurrentPaymentRepository;
        this.executedScheduledRecurrentPaymentRepository = executedScheduledRecurrentPaymentRepository;
    }

    public ExecutedScheduledRecurrentPaymentResponse create(ExecutedScheduledRecurrentPaymentRequest request) {
        ScheduledRecurrentPayment scheduled = scheduledRecurrentPaymentRepository.findById(request.scheduledRecurrentPaymentId)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

        ExecutedScheduledRecurrentPayment entity = new ExecutedScheduledRecurrentPayment();
        entity.setScheduledRecurrentPayment(scheduled);
        entity.setExecutionDate(request.executionDate);
        entity.setSuccess(request.success);
        entity.setRetries(request.retries);
        entity.setTransactionStatus(request.transactionStatus);
        entity.setErrorMessage(request.errorMessage);

        ExecutedScheduledRecurrentPayment saved = executedScheduledRecurrentPaymentRepository.save(entity);

        ExecutedScheduledRecurrentPaymentResponse response = new ExecutedScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        response.scheduledRecurrentPaymentId = scheduled.getId();
        return response;
    }

    public ExecutedScheduledRecurrentPaymentResponse update(long id, ExecutedScheduledRecurrentPaymentRequest request) {
        ExecutedScheduledRecurrentPayment entity = executedScheduledRecurrentPaymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ExecutedScheduledRecurrentPayment not found"));

        ScheduledRecurrentPayment scheduled = scheduledRecurrentPaymentRepository.findById(request.scheduledRecurrentPaymentId)
                .orElseThrow(() -> new RuntimeException("ScheduledRecurrentPayment not found"));

        entity.setScheduledRecurrentPayment(scheduled);
        entity.setExecutionDate(request.executionDate);
        entity.setSuccess(request.success);
        entity.setRetries(request.retries);
        entity.setTransactionStatus(request.transactionStatus);
        entity.setErrorMessage(request.errorMessage);

        ExecutedScheduledRecurrentPayment saved = executedScheduledRecurrentPaymentRepository.save(entity);

        ExecutedScheduledRecurrentPaymentResponse response = new ExecutedScheduledRecurrentPaymentResponse();
        BeanUtils.copyProperties(saved, response);
        response.scheduledRecurrentPaymentId = scheduled.getId();
        return response;
    }
}
