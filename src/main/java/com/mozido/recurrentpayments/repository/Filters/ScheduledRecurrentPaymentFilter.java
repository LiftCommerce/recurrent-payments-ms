package com.mozido.recurrentpayments.repository.Filters;

import com.mozido.recurrentpayments.model.PaymentFrequency;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduledRecurrentPaymentFilter {
    private String tenantName;
    private String userId;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private Integer endAfter;
    private PaymentType type;
    private PaymentFrequency frequency;
    private PaymentStatus status;
    private String cancelUserId;
    private LocalDate cancelDateTime;
    private Boolean userAccepted;
    private Boolean userDecline;
    private Boolean userSuppressReminders;
    private Boolean pendingSenderApproval;
    private LocalDate lastProcessedDate;
    private String notes;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public Integer getEndAfter() {
        return endAfter;
    }

    public void setEndAfter(Integer endAfter) {
        this.endAfter = endAfter;
    }

    public PaymentType getType() {
        return type;
    }

    public void setType(PaymentType type) {
        this.type = type;
    }

    public PaymentFrequency getFrequency() {
        return frequency;
    }

    public void setFrequency(PaymentFrequency frequency) {
        this.frequency = frequency;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public String getCancelUserId() {
        return cancelUserId;
    }

    public void setCancelUserId(String cancelUserId) {
        this.cancelUserId = cancelUserId;
    }

    public LocalDate getCancelDateTime() {
        return cancelDateTime;
    }

    public void setCancelDateTime(LocalDate cancelDateTime) {
        this.cancelDateTime = cancelDateTime;
    }

    public Boolean getUserAccepted() {
        return userAccepted;
    }

    public void setUserAccepted(Boolean userAccepted) {
        this.userAccepted = userAccepted;
    }

    public Boolean getUserDecline() {
        return userDecline;
    }

    public void setUserDecline(Boolean userDecline) {
        this.userDecline = userDecline;
    }

    public Boolean getUserSuppressReminders() {
        return userSuppressReminders;
    }

    public void setUserSuppressReminders(Boolean userSuppressReminders) {
        this.userSuppressReminders = userSuppressReminders;
    }

    public Boolean getPendingSenderApproval() {
        return pendingSenderApproval;
    }

    public void setPendingSenderApproval(Boolean pendingSenderApproval) {
        this.pendingSenderApproval = pendingSenderApproval;
    }

    public LocalDate getLastProcessedDate() {
        return lastProcessedDate;
    }

    public void setLastProcessedDate(LocalDate lastProcessedDate) {
        this.lastProcessedDate = lastProcessedDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
