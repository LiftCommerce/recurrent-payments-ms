package com.mozido.recurrentpayments.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.mozido.recurrentpayments.model.KycProvider;
import com.mozido.recurrentpayments.util.StringUtil;
import jakarta.persistence.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;

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

    private Boolean isEncrypted;
    private String companyId;

    @Column(columnDefinition = "TEXT")
    private String token;

    @Column(columnDefinition = "TEXT")
    private String refreshToken;

    private Long lastSignOn;
    private Long expiresIn;
    private Long tokenExpiresAtSeconds;
    private String outh;

    //private String promoId;
    private String campaignId;
    //One Signal
    private String appId;
    private String key;
    private String appIdMerchant;
    private String keyMerchant;

    private String interfaceName;

    //@Column(columnDefinition = "varchar(8) default '840'")
    @ColumnDefault("840")
    private String defaultCurrency;

    //KYC
    private Boolean isKycRequired;
    private String kycLevel;
    private KycProvider kycProvider;
    private Double minScore;
    //CRYPTO
    @Column(name = "is_crypto_active", columnDefinition = "boolean default false")
    private Boolean isCryptoActive;

    @JsonManagedReference
    @OneToMany(mappedBy = "setting", cascade = CascadeType.ALL)
    private List<SettingCurrency> settingCurrencies;

    @Column(name = "is_two_factor_auth_required", columnDefinition = "boolean default false")
    private Boolean isTwoFactorAuthRequired;

    @Column(name = "two_factor_auth_length", columnDefinition = "integer default 6")
    private Integer twoFactorAuthLength;

    @Column(name = "is_phone_credential", columnDefinition = "boolean default true")
    private Boolean isPhoneCredential;

    @Column(name = "is_email_credential", columnDefinition = "boolean default true")
    private Boolean isEmailCredential;

    private Integer twoFactorValidityDays;

    public Boolean getIsPhoneCredential() {
        return isPhoneCredential;
    }

    public void setIsPhoneCredential(Boolean phoneCredential) {
        isPhoneCredential = phoneCredential;
    }

    public Boolean getIsEmailCredential() {
        return isEmailCredential;
    }

    public void setIsEmailCredential(Boolean emailCredential) {
        isEmailCredential = emailCredential;
    }

    public Setting() {
    }

    public Double getMinScore() {
        return minScore;
    }

    public void setMinScore(Double minScore) {
        this.minScore = minScore;
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

    public String getDefaultCurrency() {
        return defaultCurrency;
    }

    public void setDefaultCurrency(String defaultCurrency) {
        this.defaultCurrency = defaultCurrency;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Boolean getIsEncrypted() {
        return isEncrypted;
    }

    public void setIsEncrypted(Boolean encrypted) {
        isEncrypted = encrypted;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
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

    public String getOuth() {
        return outh;
    }

    public void setOuth(String outh) {
        this.outh = outh;
    }

    public String getCampaignId() {
        return campaignId;
    }

    public void setCampaignId(String campaignId) {
        this.campaignId = campaignId;
    }

    public void encrypt() {
        this.password = StringUtil.encrypt(this.password, this.username);
        this.isEncrypted = true;
    }

    public void decrypt() {
        this.password = StringUtil.decrypt(this.password, this.username);
        //this.isEncrypted = true;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getInterfaceName() {
        return interfaceName;
    }

    public void setInterfaceName(String interfaceName) {
        this.interfaceName = interfaceName;
    }

    public Long getTokenExpiresAtSeconds() {
        return tokenExpiresAtSeconds;
    }

    public void setTokenExpiresAtSeconds(Long tokenExpiresAtSeconds) {
        this.tokenExpiresAtSeconds = tokenExpiresAtSeconds;
    }

    public String getAppIdMerchant() {
        return appIdMerchant;
    }

    public void setAppIdMerchant(String appIdMerchant) {
        this.appIdMerchant = appIdMerchant;
    }

    public String getKeyMerchant() {
        return keyMerchant;
    }

    public void setKeyMerchant(String keyMerchant) {
        this.keyMerchant = keyMerchant;
    }

    public Boolean getIsKycRequired() {
        return isKycRequired;
    }

    public void setIsKycRequired(Boolean kycRequired) {
        isKycRequired = kycRequired;
    }

    public String getKycLevel() {
        return kycLevel;
    }

    public void setKycLevel(String kycLevel) {
        this.kycLevel = kycLevel;
    }

    public String getTenantEmail() {
        return tenantEmail;
    }

    public void setTenantEmail(String tenantEmail) {
        this.tenantEmail = tenantEmail;
    }

    public KycProvider getKycProvider() {
        return kycProvider;
    }

    public void setKycProvider(KycProvider kycProvider) {
        this.kycProvider = kycProvider;
    }

    public Boolean getIsCryptoActive() {
        return isCryptoActive;
    }

    public void setIsCryptoActive(Boolean isCryptoActive) {
        this.isCryptoActive = isCryptoActive;
    }

    public List<SettingCurrency> getSettingCurrencies() {
        return settingCurrencies;
    }

    public void setSettingCurrencies(List<SettingCurrency> settingCurrencies) {
        this.settingCurrencies = settingCurrencies;
    }

    public Boolean getIsTwoFactorAuthRequired() {
        return isTwoFactorAuthRequired;
    }

    public void setIsTwoFactorAuthRequired(Boolean isTwoFactorRequired) {
        isTwoFactorAuthRequired = isTwoFactorRequired;
    }

    public Integer getTwoFactorAuthLength() {
        return twoFactorAuthLength;
    }

    public void setTwoFactorAuthLength(Integer twoFactorAuthLength) {
        this.twoFactorAuthLength = twoFactorAuthLength;
    }

    public Integer getTwoFactorValidityDays() {
        return twoFactorValidityDays;
    }

    public void setTwoFactorValidityDays(Integer twoFactorValidityDays) {
        this.twoFactorValidityDays = twoFactorValidityDays;
    }
}