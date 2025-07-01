package com.mozido.recurrentpayments.model.response;


import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

public class MozidoTransactionInfoResponse {
    private String timeStamp;
    private String transactionId;
    private List<MozidoAttributesDetail> details;


    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public void setTransactionId(String transactionId) {
        this.transactionId = transactionId;
    }

    public List<MozidoAttributesDetail> getDetails() {
        return details;
    }

    public void setDetails(List<MozidoAttributesDetail> details) {
        this.details = details;
    }
}
