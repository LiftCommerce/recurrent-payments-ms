package com.mozido.recurrentpayments.model.request;

import com.mozido.recurrentpayments.model.PaymentFrequency;
import com.mozido.recurrentpayments.model.PaymentStatus;
import com.mozido.recurrentpayments.model.PaymentTransactionType;
import com.mozido.recurrentpayments.model.PaymentType;
import java.math.BigDecimal;
import java.time.DayOfWeek;
import java.time.LocalDate;

/**
 * Created by Rafael Richards on 06/25.
 */

public class ScheduledRecurrentPaymentRequest {
    private String tenantName;
    private String userId;
    private String svaId;
    private String basketId;
    private String username;
    private String companyCode;
    private Double amount;
    private LocalDate startDate;
    private DayOfWeek dayOfWeek;
    private Integer dayOfMonth;
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

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
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

    public int getEndAfter() {
        return endAfter;
    }

    public void setEndAfter(int endAfter) {
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

    public DayOfWeek getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(DayOfWeek dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Integer getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(Integer dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }
}
