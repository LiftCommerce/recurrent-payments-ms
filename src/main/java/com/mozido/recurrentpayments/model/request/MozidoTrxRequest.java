package com.mozido.recurrentpayments.model.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by Rafael Richards on 06/25.
 */

@Schema(description = "Json model required make a call to Fundz")
public class MozidoTrxRequest {

    @JsonIgnore
    private String tenantName;

    @JsonIgnore
    private String token;

    @JsonIgnore
    private String playerId;

    @JsonIgnore
    private Boolean valid;

    @JsonIgnore
    private String merchantId;


    public MozidoTrxRequest() {
    }

    public MozidoTrxRequest(String tenantName, String token, String playerId) {
        this.tenantName = tenantName;
        this.token = token;
        this.playerId = playerId;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getPlayerId() {
        return playerId;
    }

    public void setPlayerId(String playerId) {
        this.playerId = playerId;
    }

    public Boolean getValid() {
        return valid;
    }

    public void setValid(Boolean valid) {
        this.valid = valid;
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId;
    }

}
