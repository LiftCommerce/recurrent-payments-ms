package com.mozido.recurrentpayments.model.request;

import com.mozido.recurrentpayments.exception.ControllerException;
import com.mozido.recurrentpayments.model.Language;
import io.swagger.v3.oas.annotations.media.Schema;

import static com.mozido.recurrentpayments.exception.ErrorResponses.TENANT_NOT_FOUND;


/**
 * Created by kendy on 17/10/19.
 */
@Schema(description = "Json model required to create an event")
public class ContributeToEventRequest extends MozidoTrxRequest {

    @Schema(description = "Indicates the id of an event")
    private Long id;

    @Schema(description = "Amount to contribute")
    private Double amount;

//    @JsonIgnore
    @Schema(description = "SVA where the money will be taked")
    private String svaId;

    public ContributeToEventRequest(Double amount, Long eventId, String tenantName, String token) {
        this.setAmount(amount);
        this.setId(eventId);
        this.setTenantName(tenantName);
        this.setToken(token);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Boolean isValid() throws ControllerException {
        if (null == this.getTenantName()) {
            throw new ControllerException(TENANT_NOT_FOUND, Language.ENGLISH);
        }
        if (null != this.id && null != this.amount) {
            return true;
        }
        return false;
    }
}
