package com.mozido.recurrentpayments.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by Rafael Richards on 06/25.
 */

@Schema(description = "Json model required to create a Basket")
public class PersonToPersonRequest extends MozidoTrxRequest{

    @Schema(description = "Indicates the username of the receiver")
    private String username;

    @Schema(description = "Amount to contribute")
    private Double amount;

    @Schema(description = "SVA source")
    private String svaId;

    @Schema(description = "subject")
    private String subject;

    @Schema(description = "Currency of the transaction")
    private String currencyCode;

    public PersonToPersonRequest() {
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSvaId() {
        return svaId;
    }

    public void setSvaId(String svaId) {
        this.svaId = svaId;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

}