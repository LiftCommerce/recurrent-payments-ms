package com.mozido.recurrentpayments.model.response;

import com.mozido.recurrentpayments.model.PaymentTransactionStatus;

import java.time.LocalDate;

public class ExecutedScheduledRecurrentPaymentResponse {
    public long id;
    public long scheduledRecurrentPaymentId;
    public LocalDate executionDate;
    public boolean success;
    public int retries;
    public PaymentTransactionStatus transactionStatus;
    public String errorMessage;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getScheduledRecurrentPaymentId() {
        return scheduledRecurrentPaymentId;
    }

    public void setScheduledRecurrentPaymentId(long scheduledRecurrentPaymentId) {
        this.scheduledRecurrentPaymentId = scheduledRecurrentPaymentId;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getRetries() {
        return retries;
    }

    public void setRetries(int retries) {
        this.retries = retries;
    }

    public PaymentTransactionStatus getTransactionStatus() {
        return transactionStatus;
    }

    public void setTransactionStatus(PaymentTransactionStatus transactionStatus) {
        this.transactionStatus = transactionStatus;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
