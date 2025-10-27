package com.mozido.recurrentpayments.model.response;

import com.mozido.recurrentpayments.model.Status;
import com.mozido.recurrentpayments.model.Store;

import java.util.ArrayList;
import java.util.List;

public class GetUserResponse extends BaseResponse{

    private String username;
    private String firstName;
    private String lastName;
    private String nickname;
    private String name;
    private String imgUrl;
    private Boolean isBlocked;
    private String uuid;
    private Status status;
    private String email;
    private List<Store> companies;

    public GetUserResponse() {
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

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getBlocked() {
        return isBlocked;
    }

    public void setBlocked(Boolean blocked) {
        isBlocked = blocked;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Store> getCompanies() {
        return companies;
    }

    public void setCompanies(List<Store> companies) {
        this.companies = companies;
    }
}
