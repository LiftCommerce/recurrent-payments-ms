package com.mozido.recurrentpayments.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonInclude;
import jakarta.persistence.*;

import java.util.Date;

/**
 * Created by Orlando on 07/21.
 */

public class UserCompany {

    private long id;
    private User user;
    private Company company;

    private Status status;
    private Date createdDate;
    private Date updatedDate;
    private String title;

    public UserCompany(){ }


    public UserCompany(User user, Company company, Status status, Date createdDate, Date updatedDate, String title) {
        this.user = user;
        this.company = company;
        this.status = status;
        this.createdDate = createdDate;
        this.updatedDate = updatedDate;
        this.title = title;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
