package com.mozido.recurrentpayments.model;


import jakarta.persistence.*;
import org.hibernate.loader.ast.internal.CacheEntityLoaderHelper;

import java.util.Date;
import java.util.List;

/**
 * Created by Orlando on 04/21.
 */

public class Company {

    private long id;

    private String tenantName;
    private String userUUID;
    private String svaId;
    private String companyName;
    private String companyCode;
    private String imgUrl;
    private Date createdDate;
    private Integer currencyCode;
    private Integer companyId;
    private String country;
    private String email;
    private String defaultCampaign;
    private Boolean isCampaignActive;
    private String telephone;
    private String webSite;

    private Boolean hasParent;
    private Boolean isHealthCare;
    private Integer healthCareId;
    private String googlePlaceId;

    private String timezone;

    private String description;

    private String profileItems;

    private CacheEntityLoaderHelper.EntityStatus status;

    private List<Payment> payments;

    private List<UserCompany> userCompanies;

    private Address addresses;


    public Company(){
        this.createdDate = new Date();
    }


    public Boolean getIsHealthCare() {
        return isHealthCare;
    }

    public void setIsHealthCare(Boolean healthCare) {
        isHealthCare = healthCare;
    }

    public Boolean getHasParent() {
        return hasParent;
    }

    public void setHasParent(Boolean hasParent) {
        this.hasParent = hasParent;
    }

    public Integer getHealthCareId() {
        return healthCareId;
    }

    public void setHealthCareId(Integer healthCareId) {
        this.healthCareId = healthCareId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
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


    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }


    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }


    public Integer getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(Integer currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDefaultCampaign() {
        return defaultCampaign;
    }

    public void setDefaultCampaign(String defaultCampaign) {
        this.defaultCampaign = defaultCampaign;
    }

    public Boolean getIsCampaignActive() {
        return isCampaignActive;
    }

    public void setIsCampaignActive(Boolean campaignActive) {
        isCampaignActive = campaignActive;
    }

    public List<UserCompany> getUserCompanies() {
        return userCompanies;
    }

    public void setUserCompanies(List<UserCompany> userCompanies) {
        this.userCompanies = userCompanies;
    }

    public Address getAddresses() {
        return addresses;
    }

    public void setAddresses(Address addresses) {
        this.addresses = addresses;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CacheEntityLoaderHelper.EntityStatus getStatus() {
        return status;
    }

    public void setStatus(CacheEntityLoaderHelper.EntityStatus status) {
        this.status = status;
    }

    public String getProfileItems() {
        return profileItems;
    }

    public void setProfileItems(String profileItems) {
        this.profileItems = profileItems;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Company company = (Company) o;

        if (id != company.id) return false;
        if (tenantName != null ? !tenantName.equals(company.tenantName) : company.tenantName != null) return false;
        if (companyCode != null ? !companyCode.equals(company.companyCode) : company.companyCode != null) return false;
        if (companyId != null ? !companyId.equals(company.companyId) : company.companyId != null) return false;
        return email != null ? email.equals(company.email) : company.email == null;
    }

    @Override
    public int hashCode() {
        int result = (int) (id ^ (id >>> 32));
        result = 31 * result + (tenantName != null ? tenantName.hashCode() : 0);
        result = 31 * result + (companyCode != null ? companyCode.hashCode() : 0);
        result = 31 * result + (companyId != null ? companyId.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
