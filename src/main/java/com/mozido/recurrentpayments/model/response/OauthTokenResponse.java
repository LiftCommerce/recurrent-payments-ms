package com.mozido.recurrentpayments.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by orlando on 29/10/18.
 */
public class OauthTokenResponse extends BaseResponse{

    @JsonProperty(value = "access_token")
    @Schema(description = "Access token, is the Authorization token to be used in the calls required")
    private String accessToken;

    @JsonProperty(value = "expires_in")
    @Schema(description = "Time of token expiration on seconds")
    private Long expiresIn;

    @Schema(description = "jti")
    private String jti;

    @Schema(description = "app_name")
    private String appName;

    @JsonProperty(value = "last_signon_timestamp")
    @Schema(description = "Last sign on")
    private Long lastSignonTimestamp;

    @Schema(description = "This token is valid for 3 months, you can get a new access token without login.")
    @JsonProperty(value = "refresh_token")
    private String refreshToken;

    @Schema(description = "read write")
    private String scope;

    @Schema(description = "Tenant that user belongs")
    @JsonProperty(value = "tenant_name")
    private String tenantName;

    @Schema(description = "Type of token, Bearer is default")
    @JsonProperty(value = "token_type")
    private String tokenType;

    @Schema(description = "Role of the user on the platform ")
    @JsonProperty(value = "user_type")
    private String userType;

    @Schema(description = "Unique identifier of the user")
    private String uuid;

    @JsonProperty(value = "need_change_password")
    private Boolean needChangePassword;


    public OauthTokenResponse() {
    }



    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(Long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getJti() {
        return jti;
    }

    public void setJti(String jti) {
        this.jti = jti;
    }

    public Long getLastSignonTimestamp() {
        return lastSignonTimestamp;
    }

    public void setLastSignonTimestamp(Long lastSignonTimestamp) {
        this.lastSignonTimestamp = lastSignonTimestamp;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getTokenType() {
        return tokenType;
    }

    public void setTokenType(String tokenType) {
        this.tokenType = tokenType;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public Boolean getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Boolean needChangePassword) {
        this.needChangePassword = needChangePassword;
    }

    public String getAppName() {
        return appName;
    }

    public void setAppName(String appName) {
        this.appName = appName;
    }
}
