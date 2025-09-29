package com.mozido.recurrentpayments.entity;

import com.mozido.recurrentpayments.util.StringUtil;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

@Entity
@Table(schema = "payments", name = "setting")
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    //Tenant Info
    private String tenantName;
    private String tenantEmail;
    private String username;
    private String password;
    private String url;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    private Boolean isEncrypted;
    private String interfaceName;

    private Long lastSignOn;
    private Long expiresIn;
    private Long tokenExpiresAtSeconds;
    private String outh;

    @ColumnDefault("840")
    private String defaultCurrency;

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Long getLastSignOn() {
        return lastSignOn;
    }

    public void setLastSignOn(Long lastSignOn) {
        this.lastSignOn = lastSignOn;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public Long getTokenExpiresAtSeconds() {
        return tokenExpiresAtSeconds;
    }

    public void setTokenExpiresAtSeconds(Long tokenExpiresAtSeconds) {
        this.tokenExpiresAtSeconds = tokenExpiresAtSeconds;
    }

    public String getOuth() {
        return outh;
    }

    public void setOuth(String outh) {
        this.outh = outh;
    }

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public Boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(Boolean encrypted) {
        isEncrypted = encrypted;
    }

    public void encrypt() {
        this.password = StringUtil.encrypt(this.password, this.username);
        this.isEncrypted = true;
    }

    public void decrypt() {
        this.password = StringUtil.decrypt(this.password, this.username);
    }

}
