package com.mozido.recurrentpayments.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.google.gson.Gson;
import io.swagger.v3.oas.annotations.media.Schema;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Store {

    @Schema(description = "Company name")
    private String name;
    @Schema(description = "Company Code, (unique value) required on some others Apis")
    private String companyCode;
    @Schema(description = "Company category")
    private String categoryCode;
    @Schema(description = "Country of the company")
    private String country;
    @Schema(description = "Status, Active/Inactive")
    private String status;
    @Schema(description = "Numeric Id, (unique value) required on some others Apis")
    private Integer companyId;
    @Schema(description = "Url of the logo image ")
    private String logoUrl;

    @Schema(description = "Url of the webpage ")
    private String webSite;

    @Schema(description = "Store email ")
    private String email;
    @Schema(description = "timezone  ")
    private String timezone;
    @Schema(description = "Store email ")
    private Integer healthcareId;

    @Schema(description = "Store phone ")
    private String phone;

    private String googlePlaceId;

    private String address;

    private Double lat;

    private Double lon;

    @Schema(description = "Campaign")
    private String campaign;

    @Schema(description = "Store Description ")
    private String description;

    private String[] customFields_2;

    private String profileItems;

    private Boolean isDefault;

    private String userUuid;

    public Store() {
    }

    public Store(Company company) {
        this.name = company.getCompanyName();
        String[] clean = {"empty"};
        this.setCustomFields_2(clean);
        this.companyCode = company.getCompanyCode();
        this.companyId = company.getCompanyId();
        if (null != company.getImgUrl() && company.getImgUrl() != "")
            this.logoUrl = company.getImgUrl();
        else
            this.logoUrl = "https://api.cloudpayments-staging.com/fundz-ms/img/1729517678file20241021_13410.jpg";
        if(null!=company.getDescription())
            this.description = company.getDescription();
        this.country = company.getCountry();
        if(null!= company.getStatus())
            this.status = company.getStatus().name();
        else
            this.status = "ACTIVE";
        this.email = company.getEmail();
        if (null != company.getTimezone())
            this.timezone = company.getTimezone();
        this.healthcareId = company.getHealthCareId();
        if(null!= company.getGooglePlaceId())
            this.googlePlaceId = company.getGooglePlaceId();
        if(null!=company.getTelephone())
            this.phone = company.getTelephone();
        if(null!=company.getWebSite())
            this.webSite = company.getWebSite();
        if(null!=company.getDefaultCampaign())
            this.campaign = company.getDefaultCampaign();
        if(null!=company.getAddresses()){
            this.address = company.getAddresses().getStreet1() + " " + company.getAddresses().getStreet2() +
                    ", " + company.getAddresses().getCity()  + " " + company.getAddresses().getState() + " " +
                    company.getAddresses().getZipCode();
            if(null!=company.getAddresses().getLat())
                this.lat = company.getAddresses().getLat();
            if(null!=company.getAddresses().getLon())
                this.lon = company.getAddresses().getLon();
        }
        if(null!=company.getProfileItems())
            this.profileItems = company.getProfileItems();

    }

    public Store(Company company, Boolean isDefault) {
        if (company != null) {
            this.name = company.getCompanyName();
            String[] clean = {"empty"};
            this.setCustomFields_2(clean);
            this.companyCode = company.getCompanyCode();
            this.companyId = company.getCompanyId();
            if (null != company.getImgUrl() && company.getImgUrl() != "")
                this.logoUrl = company.getImgUrl();
            else
                this.logoUrl = "https://api.cloudpayments-staging.com/fundz-ms/img/1729517678file20241021_13410.jpg";
            if(null!=company.getDescription())
                this.description = company.getDescription();
            this.country = company.getCountry();
            this.status = "ACTIVE";
            this.email = company.getEmail();
            if (null != company.getTimezone())
                this.timezone = company.getTimezone();
            this.healthcareId = company.getHealthCareId();
            if(null!= company.getGooglePlaceId())
                this.googlePlaceId = company.getGooglePlaceId();
            if(null!=company.getTelephone())
                this.phone = company.getTelephone();
            if(null!=company.getWebSite())
                this.webSite = company.getWebSite();
            if(null!=company.getDefaultCampaign())
                this.campaign = company.getDefaultCampaign();
            if(null!=company.getAddresses()){
                this.address = company.getAddresses().getStreet1() + " " + company.getAddresses().getStreet2() +
                        ", " + company.getAddresses().getCity()  + " " + company.getAddresses().getState() + " " +
                        company.getAddresses().getZipCode();
                if(null!=company.getAddresses().getLat())
                    this.lat = company.getAddresses().getLat();
                if(null!=company.getAddresses().getLon())
                    this.lon = company.getAddresses().getLon();
            }
            if(null!=company.getProfileItems())
                this.profileItems = company.getProfileItems();
            this.isDefault = isDefault;
            if (company.getUserUUID() != null) {
                this.userUuid = company.getUserUUID();
            }
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public Integer getHealthcareId() {
        return healthcareId;
    }

    public void setHealthcareId(Integer healthcareId) {
        this.healthcareId = healthcareId;
    }

    public String getGooglePlaceId() {
        return googlePlaceId;
    }

    public void setGooglePlaceId(String googlePlaceId) {
        this.googlePlaceId = googlePlaceId;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getWebSite() {
        return webSite;
    }

    public void setWebSite(String webSite) {
        this.webSite = webSite;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String[] getCustomFields_2() {
        return customFields_2;
    }

    public void setCustomFields_2(String[] customFields_2) {
        this.customFields_2 = customFields_2;
    }

    public String getCampaign() {
        return campaign;
    }

    public void setCampaign(String campaign) {
        this.campaign = campaign;
    }

    public Boolean getDefault() {
        return isDefault;
    }

    public void setDefault(Boolean aDefault) {
        isDefault = aDefault;
    }

    public ProfileItem[] getProfileItems() {
        Gson gson = new Gson();
        ProfileItem[] socialMedia = gson.fromJson(this.profileItems, ProfileItem[].class);
        return socialMedia;
    }

    public void setProfileItems(String profileItems) {
        this.profileItems = profileItems;
    }

    public String getUserUuid() {
        return userUuid;
    }

    public void setUserUuid(String userUuid) {
        this.userUuid = userUuid;
    }

    //Avoid duplicates by Id
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        if (!companyId.equals(store.companyId)) return false;
        return true;
    }

    @Override
    public int hashCode() {
        return companyId.hashCode();
    }
}
