package com.mozido.recurrentpayments.model;

import jakarta.persistence.*;
import java.util.Date;

/**
 * Created by kendy on 10/15/19.
 */

public class Payment {

    private long id;

    private String tenantName;

    private Event event;

    private User user;

    private Company company;


    private String username;
    private String name;
    private Double amount;
    private String svaId;
    private String paymentId;
    private Date createdDate;
    private String subject;

    private String currencyCode;

    public Payment(){
        this.amount = 0.0;
        this.createdDate = new Date();
    }

    public Payment(Event event, User user, Double amount, String svaId, String paymentId){
        this();
        this.tenantName = event.getTenantName();
        this.event = event;
        this.username = user.getUsername();
        this.name = user.getFirstName() + " " + user.getLastName();
        this.amount = amount;
        this.svaId = svaId;
        this.paymentId = paymentId;
        if(null!=event.getCurrencyCode())
            this.currencyCode = event.getCurrencyCode();
    }

    public Payment(Event event, String username, String name, Double amount, String svaId, String paymentId){
        this();
        this.tenantName = event.getTenantName();
        this.event = event;
        this.username = username;
        this.name = name;
        this.amount = amount;
        this.svaId = svaId;
        this.paymentId = paymentId;
        if(null!=event.getCurrencyCode())
            this.currencyCode = event.getCurrencyCode();
    }

    public Payment(User receiver, String username, Double amount, String svaId, String paymentId, String subject){
        this();
        this.tenantName = receiver.getTenantName();
        this.user = receiver;
        this.username = username;
        this.amount = amount;
        this.svaId = svaId;
        this.paymentId = paymentId;
        this.subject = subject;
    }

    public Payment(Company receiver, String username, Double amount, String svaId, String paymentId, String subject){
        this();
        this.tenantName = receiver.getTenantName();
        this.company = receiver;
        this.username = username;
        this.amount = amount;
        this.svaId = svaId;
        this.paymentId = paymentId;
        this.subject = subject;

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

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSvaId() {
        return svaId;
    }

    public void setSvaId(String svaId) {
        this.svaId = svaId;
    }

    public String getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(String paymentId) {
        this.paymentId = paymentId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
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
}
