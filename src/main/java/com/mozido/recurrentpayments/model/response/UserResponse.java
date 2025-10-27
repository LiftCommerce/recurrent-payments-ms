package com.mozido.recurrentpayments.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.mozido.recurrentpayments.model.Address;
import com.mozido.recurrentpayments.model.Store;
import com.mozido.recurrentpayments.model.Summary;
import com.mozido.recurrentpayments.model.User;
import io.swagger.v3.oas.annotations.media.Schema;

import java.util.Date;
import java.util.List;
import java.util.Set;


/**
 * Created by Orlando on 10/15/19.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserResponse {
    private long id;
    private String tenantName;
    private String userUUID;
    private String username;
    private String svaId;
    private String firstName;
    private String lastName;
    private String name;

    private String nickname;
    private String imgUrl;
    private String telephone;
    private String email;
    private String playerId;
    private Date createdDate;
    private Double accountBalance;
    private Double creditHoldBalance;
    private Double holdBalance;
    private Double availableBalance;
    private Summary summary;
    private Boolean validPhone;
    private Boolean validEmail;
    private Store subscription;

    private Set<Store> subscriptions;
    private Date birthDate;

    @Schema(description = "Reward points Balance")
    private Integer rewardsPoints;

    @Schema(description = "rewardRate")
    private Integer rewardRate;

    private List<Address> addresses;

    private Set<Store> merchants;


    public UserResponse(User user , String serverImgUrl){
        //this();
        this.id = user.getId();
        this.tenantName = user.getTenantName();
        this.userUUID = user.getUserUUID();
        this.username = user.getUsername();
        this.svaId = user.getSvaId();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
        this.name = user.getName();
        if(null!= user.getImgUrl())
            this.imgUrl = serverImgUrl + user.getImgUrl();
        else
            this.imgUrl = null;
        if(null!= user.getTelephone())
            this.telephone = user.getTelephone();
        else
            this.telephone = null;
        if(null!= user.getEmail())
            this.email = user.getEmail();
        else
            this.email = null;

        if(null!=playerId)
            this.playerId = user.getPlayerId();
        else
            this.playerId = null;
        this.createdDate = user.getCreatedDate();
        //this.addresses = user.getAddresses();

        this.validPhone = user.getValidPhone();
        this.validEmail = user.getValidEmail();
        if(null!=user.getBirthDate())
            this.birthDate = user.getBirthDate();
        if(null!=user.getNickname())
            this.nickname = user.getNickname();
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Double getAccountBalance() {
        return accountBalance;
    }

    public void setAccountBalance(Double accountBalance) {
        this.accountBalance = accountBalance;
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

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Double getCreditHoldBalance() {
        return creditHoldBalance;
    }

    public void setCreditHoldBalance(Double creditHoldBalance) {
        this.creditHoldBalance = creditHoldBalance;
    }

    public Double getHoldBalance() {
        return holdBalance;
    }

    public void setHoldBalance(Double holdBalance) {
        this.holdBalance = holdBalance;
    }

    public Double getAvailableBalance() {
        return availableBalance;
    }

    public void setAvailableBalance(Double availableBalance) {
        this.availableBalance = availableBalance;
    }

    public Store getSubscription() {
        return subscription;
    }

    public void setSubscription(Store subscription) {
        this.subscription = subscription;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getRewardsPoints() {
        return rewardsPoints;
    }

    public void setRewardsPoints(Integer rewardsPoints) {
        this.rewardsPoints = rewardsPoints;
    }

    public Integer getRewardRate() {
        return rewardRate;
    }

    public void setRewardRate(Integer rewardRate) {
        this.rewardRate = rewardRate;
    }

    public Set<Store> getMerchants() {
        return merchants;
    }

    public void setMerchants(Set<Store> merchants) {
        this.merchants = merchants;
    }

    public void setSubscriptions(Set<Store> subscriptions) {
        this.subscriptions = subscriptions;
    }

    public Set<Store> getSubscriptions() {
        return subscriptions;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }
}
