package com.mozido.recurrentpayments.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.mozido.recurrentpayments.model.PaymentFrequency;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentTransactionStatus;
import com.mozido.recurrentpayments.model.PaymentType;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by Rafael Richards on 06/25.
 */

@Entity
@Table(schema = "payments", name = "executed_scheduled_recurrent_payment")
public class ExecutedScheduledRecurrentPayment {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "scheduled_recurrent_payment_id", nullable = false)
    private ScheduledRecurrentPayment scheduledRecurrentPayment;

    private LocalDate executionDate;
    private boolean success;
    private int retries;
    private PaymentTransactionStatus transactionStatus;
    private String errorMessage;

    public long getId() {
        return id;
    }

    public ScheduledRecurrentPayment getPaymentId() {
        return scheduledRecurrentPayment;
    }

    public void setPaymentId(ScheduledRecurrentPayment paymentId) {
        this.scheduledRecurrentPayment = paymentId;
    }

    public LocalDate getExecutionDate() {
        return executionDate;
    }

    public void setExecutionDate(LocalDate executionDate) {
        this.executionDate = executionDate;
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public ScheduledRecurrentPayment getScheduledRecurrentPayment() {
        return scheduledRecurrentPayment;
    }

    public void setScheduledRecurrentPayment(ScheduledRecurrentPayment scheduledRecurrentPayment) {
        this.scheduledRecurrentPayment = scheduledRecurrentPayment;
    }
}
