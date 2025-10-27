package com.mozido.recurrentpayments.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by kendy on 10/15/19.
 */


public class Event {

    private long id;
    private String tenantName;
    private String userUUID;
    private String username;
    private String firstName;
    private String lastName;
    private String svaId;
    private String name;
    private String description;
    private String imgUrl;
    private Date startDate;
    private Date endDate;
    private Double goalAmount;
    private Integer estimatedContributors;
    private Double suggestedAmount;
    private Double balance;
    private Double contributedBalance;
    private Double percentageReached;
    private EventType type;
    private String subType;
    private EventStatus status;
    private String timeZone;

    private String currencyCode;

    private Company company;

    private List<Contributor> contributors;

    private List<Payment> payments;
    private Date createDate;
    private Date updateDate;


    Set<User> userSet;

    private Date nextPlannedStatusDate;
    private EventStatus nextPlannedStatus;


    public Event() {
        this.balance = 0.0;
        this.contributedBalance = 0.0;
        this.percentageReached = 0.0;
        this.createDate = new Date();
        this.updateDate = this.createDate;
        this.status = EventStatus.ACTIVE;
        this.contributors = new ArrayList();
        this.payments = new ArrayList();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUserUUID() {
        return userUUID;
    }

    public void setUserUUID(String userUUID) {
        this.userUUID = userUUID;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSvaId() {
        return svaId;
    }

    public void setSvaId(String svaId) {
        this.svaId = svaId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public Double getGoalAmount() {
        return goalAmount;
    }

    public void setGoalAmount(Double goalAmount) {
        this.goalAmount = goalAmount;
    }

    public Integer getEstimatedContributors() {
        return estimatedContributors;
    }

    public void setEstimatedContributors(Integer estimatedContributors) {
        this.estimatedContributors = estimatedContributors;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public Double getSuggestedAmount() {
        return suggestedAmount;
    }

    public void setSuggestedAmount(Double suggestedAmount) {
        this.suggestedAmount = suggestedAmount;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public Double getContributedBalance() {
        return contributedBalance;
    }

    public void setContributedBalance(Double contributedBalance) {
        this.contributedBalance = contributedBalance;
    }

    public Double getPercentageReached() {
        return percentageReached;
    }

    public void setPercentageReached(Double percentageReached) {
        this.percentageReached = percentageReached;
    }

    public EventType getType() {
        return type;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public EventStatus getStatus() {
        return status;
    }

    public void setStatus(EventStatus status) {
        this.status = status;
    }

    public List<Contributor> getContributors() {
        return contributors;
    }

    public void setContributors(List<Contributor> contributors) {
        this.contributors = contributors;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public void updateSuggestedAmount() {
        if (EventType.FIXED.equals(this.type) && null != this.goalAmount && null != this.estimatedContributors) {
            BigDecimal bd = BigDecimal.valueOf(this.goalAmount / this.estimatedContributors);
            bd = bd.setScale(2, RoundingMode.HALF_UP);
            this.suggestedAmount = bd.doubleValue();
        }
    }

    public void updatePorcentageReached() {
        BigDecimal bd = BigDecimal.valueOf(this.contributedBalance / this.goalAmount);
        bd = bd.setScale(2, RoundingMode.HALF_DOWN);
        this.contributedBalance = bd.doubleValue();
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public Date getNextPlannedStatusDate() {
        return nextPlannedStatusDate;
    }

    public void setNextPlannedStatusDate(Date nextPlannedStatusDate) {
        this.nextPlannedStatusDate = nextPlannedStatusDate;
    }

    public EventStatus getNextPlannedStatus() {
        return nextPlannedStatus;
    }

    public void setNextPlannedStatus(EventStatus nextPlannedStatus) {
        this.nextPlannedStatus = nextPlannedStatus;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
}
