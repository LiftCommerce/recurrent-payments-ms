package com.mozido.recurrentpayments.repository.Filters;

import com.mozido.recurrentpayments.model.PaymentFrequency;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentTransactionType;
import com.mozido.recurrentpayments.model.PaymentType;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ScheduledRecurrentPaymentFilter {

    private String tenantName;
    private String userId;
    private String svaId;
    private String basketId;
    private String basketName;
    private String username;
    private String companyCode;
    private String companyName;
    private BigDecimal amount;
    private LocalDate startDate;
    private LocalDate endDate;
    private int endAfter;
    private PaymentType type;
    private PaymentTransactionType paymentTransactionType;
    private PaymentFrequency frequency;
    private PaymentStatus status;
    private String cancelUserId;
    private LocalDate cancelDateTime;
    private boolean userAccepted;
    private boolean userDecline;
    private boolean userSuppressReminders;
    private boolean pendingSenderApproval;
    private LocalDate lastProcessedDate;
    private LocalDate nextOccurrenceDate;
    private String notes;
    private String currencyCode;

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

    public PaymentTransactionType getPaymentTransactionType() {
        return paymentTransactionType;
    }

    public void setPaymentTransactionType(PaymentTransactionType paymentTransactionType) {
        this.paymentTransactionType = paymentTransactionType;
    }

    public String getSvaId() {
        return svaId;
    }

    public void setSvaId(String svaId) {
        this.svaId = svaId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public void setEndAfter(int endAfter) {
        this.endAfter = endAfter;
    }

    public boolean isUserAccepted() {
        return userAccepted;
    }

    public void setUserAccepted(boolean userAccepted) {
        this.userAccepted = userAccepted;
    }

    public boolean isUserDecline() {
        return userDecline;
    }

    public void setUserDecline(boolean userDecline) {
        this.userDecline = userDecline;
    }

    public boolean isUserSuppressReminders() {
        return userSuppressReminders;
    }

    public void setUserSuppressReminders(boolean userSuppressReminders) {
        this.userSuppressReminders = userSuppressReminders;
    }

    public boolean isPendingSenderApproval() {
        return pendingSenderApproval;
    }

    public void setPendingSenderApproval(boolean pendingSenderApproval) {
        this.pendingSenderApproval = pendingSenderApproval;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getBasketId() {
        return basketId;
    }

    public void setBasketId(String basketId) {
        this.basketId = basketId;
    }

    public String getBasketName() {
        return basketName;
    }

    public void setBasketName(String basketName) {
        this.basketName = basketName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public LocalDate getNextOccurrenceDate() {
        return nextOccurrenceDate;
    }

    public void setNextOccurrenceDate(LocalDate nextOccurrenceDate) {
        this.nextOccurrenceDate = nextOccurrenceDate;
    }
}
