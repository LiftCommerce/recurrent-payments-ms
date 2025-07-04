package com.mozido.recurrentpayments.repository.Filters;

import com.mozido.recurrentpayments.model.PaymentTransactionStatus;

import java.time.LocalDate;

public class ExecutedScheduledRecurrentPaymentFilter {
    private Long scheduledRecurrentPaymentId;
    private LocalDate executionDate;
    private Boolean success;
    private Integer retries;
    private PaymentTransactionStatus transactionStatus;

    public Long getScheduledRecurrentPaymentId() {
        return scheduledRecurrentPaymentId;
    }

    public void setScheduledRecurrentPaymentId(Long scheduledRecurrentPaymentId) {
        this.scheduledRecurrentPaymentId = scheduledRecurrentPaymentId;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getRetries() {
        return retries;
    }

    public void setRetries(Integer retries) {
        this.retries = retries;
    }

    public PaymentTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(PaymentTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }
}
