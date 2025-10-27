package com.mozido.recurrentpayments.model;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

import static com.mozido.recurrentpayments.model.ContributorStatus.INVITED;

/**
 * Created by kendy on 10/15/19.
 */

public class Contributor {

    private long id;

    private Event event;
    private String username;
    private String name;
    private Double amount;
    private ContributorStatus status;
    private String imgUrl;

    private Date createdDate;
    private Date updatedDate;

    public Contributor(){
        this.amount = 0.0;
        this.status = INVITED;
        this.createdDate = new Date();
        this.updatedDate = createdDate;
    }

    public Contributor(Event event){
        this();
        this.event = event;
    }

    public Contributor(Event event, User user){
        this(event);
        this.username = user.getUsername();
        this.name = user.getFirstName() + user.getLastName();
    }

    public Contributor(Event event, User user, ContributorStatus status){
        this(event, user);
        this.status = status;
    }

    public Contributor(Event event, User user, ContributorStatus status, Double amount){
        this(event, user, status);
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }


    public Event getEvent() {
        return event;
    }

    public void setEventId(Event event) {
        this.event = event;
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

    public ContributorStatus getStatus() {
        return status;
    }

    public void setStatus(ContributorStatus status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contributor that = (Contributor) o;
        return event.equals(that.event) &&
                username.equals(that.username);
    }

    @Override
    public int hashCode() {
        return Objects.hash(event, username);
    }
}
