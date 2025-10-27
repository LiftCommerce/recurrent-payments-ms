package com.mozido.recurrentpayments.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class User {

    private long id;

    private String tenantName;
    private String userUUID;
    private String svaId;
    private String svaPointsId;
    private String firstName;
    private String lastName;
    private String name;
    private String imgUrl;
    private String username;
    private String nickname;
    private String telephone;
    private String email;
    private Boolean validPhone;
    private Boolean validEmail;
    private String pin;
    private String playerId;
    private String playerIdMerchantApp;
    private Date createdDate;
    private Integer currencyCode;
    private Date birthDate;

    private Date firstAppointment;
    private Date lastAppointment;

    private String timeZone;

    private String temporalEmail;

    private Integer temporalCompanyId;

    private Boolean firstLogin;

    public User() {
        this.createdDate = new Date();
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

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getValidPhone() {
        return validPhone;
    }

    public void setValidPhone(Boolean validPhone) {
        this.validPhone = validPhone;
    }

    public Boolean getValidEmail() {
        return validEmail;
    }

    public void setValidEmail(Boolean validEmail) {
        this.validEmail = validEmail;
    }

    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }

    public String getPlayerIdMerchantApp() {
        return playerIdMerchantApp;
    }

    public void setPlayerIdMerchantApp(String playerIdMerchantApp) {
        this.playerIdMerchantApp = playerIdMerchantApp;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getSvaPointsId() {
        return svaPointsId;
    }

    public void setSvaPointsId(String svaPointsId) {
        this.svaPointsId = svaPointsId;
    }

    public Date getFirstAppointment() {
        return firstAppointment;
    }

    public void setFirstAppointment(Date firstAppointment) {
        this.firstAppointment = firstAppointment;
    }

    public Date getLastAppointment() {
        return lastAppointment;
    }

    public void setLastAppointment(Date lastAppointment) {
        this.lastAppointment = lastAppointment;
    }

    public String getTimeZone() {
        return timeZone;
    }

    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getTemporalEmail() {
        return temporalEmail;
    }

    public void setTemporalEmail(String temporalEmail) {
        this.temporalEmail = temporalEmail;
    }

    public Integer getTemporalCompanyId() {
        return temporalCompanyId;
    }

    public void setTemporalCompanyId(Integer temporalCompanyId) {
        this.temporalCompanyId = temporalCompanyId;
    }

    public Boolean getFirstLogin() {
        return firstLogin;
    }

    public void setFirstLogin(Boolean firstLogin) {
        this.firstLogin = firstLogin;
    }
}
