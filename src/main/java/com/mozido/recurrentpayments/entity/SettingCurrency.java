package com.mozido.recurrentpayments.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
@Table(schema = "payments", name = "settingCurrency")
public class SettingCurrency {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @JsonBackReference
    @ManyToOne
    @JoinColumn
    private Setting setting;

    private String coinName;

    private String coinCode;

    private String imgUrl;

    private Boolean registrationRequired;
    private Boolean active;
    private Boolean cryptoCurrency;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Setting getSetting() {
        return setting;
    }

    public void setSetting(Setting setting) {
        this.setting = setting;
    }

    public String getCoinName() {
        return coinName;
    }

    public void setCoinName(String coinName) {
        this.coinName = coinName;
    }

    public String getCoinCode() {
        return coinCode;
    }

    public void setCoinCode(String coinCode) {
        this.coinCode = coinCode;
    }

    public Boolean getRegistrationRequired() {
        return registrationRequired;
    }

    public void setRegistrationRequired(Boolean registrationRequired) {
        this.registrationRequired = registrationRequired;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Boolean getCryptoCurrency() {
        return cryptoCurrency;
    }

    public void setCryptoCurrency(Boolean cryptoCurrency) {
        this.cryptoCurrency = cryptoCurrency;
    }
}