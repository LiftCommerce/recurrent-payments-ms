package com.mozido.recurrentpayments.model.request;

import io.swagger.v3.oas.annotations.media.Schema;

/**
 * Created by Rafael Richards on 06/25.
 */

@Schema(description = "Json model required to pay to a merchant")
public class PersonToMerchantRequest extends MozidoTrxRequest{


    @Schema(description = "Amount to pay")
    private Double amount;

    @Schema(description = "Transaction description")
    private String subject;

    @Schema(description = "Id of Qrcode")
    private Integer qrId;

    @Schema(description = "Indicates company code of the Merchant that receives the transfer")
    private String companyCode;

    @Schema(description = "Indicates  if is a M2M payment")
    private Boolean isM2M;

    @Schema(description = "Indicates  if is a M2M Transfer")
    private Boolean isM2MTransfer;

    @Schema(description = "Indicates containerId of the source of the transfer")
    private String containerId;

    private String currencyCode;


    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public Integer getQrId() {
        return qrId;
    }

    public void setQrId(Integer qrId) {
        this.qrId = qrId;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getContainerId() {
        return containerId;
    }

    public void setContainerId(String containerId) {
        this.containerId = containerId;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    public Boolean getIsM2M() {
        return isM2M;
    }

    public void setIsM2M(Boolean m2M) {
        isM2M = m2M;
    }

    public Boolean getIsM2MTransfer() {
        return isM2MTransfer;
    }

    public void setIsM2MTransfer(Boolean m2MTransfer) {
        isM2MTransfer = m2MTransfer;
    }
}
