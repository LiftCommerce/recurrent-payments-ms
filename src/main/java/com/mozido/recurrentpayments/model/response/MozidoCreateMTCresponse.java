package com.mozido.recurrentpayments.model.response;


import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Created by Rafael Richards on 06/25.
 */

public class MozidoCreateMTCresponse {

    private MozidoTransactionInfoResponse transactionInfo;
    private LinkedHashMap contextResponse;
    private LinkedHashMap confirmationInfo;
    private LinkedHashMap responseData;
    private Map details;
    private String errors;
    private String id;


    public MozidoTransactionInfoResponse getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(MozidoTransactionInfoResponse transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    public LinkedHashMap getContextResponse() {
        return contextResponse;
    }

    public void setContextResponse(LinkedHashMap contextResponse) {
        this.contextResponse = contextResponse;
    }

    public LinkedHashMap getConfirmationInfo() {
        return confirmationInfo;
    }

    public void setConfirmationInfo(LinkedHashMap confirmationInfo) {
        this.confirmationInfo = confirmationInfo;
    }

    public LinkedHashMap getResponseData() {
        return responseData;
    }

    public void setResponseData(LinkedHashMap responseData) {
        this.responseData = responseData;
    }

    public Map getDetails() {
        return details;
    }

    public void setDetails(Map details) {
        this.details = details;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStatusCode() {
        if(null != contextResponse){
            return (String) contextResponse.get("statusCode");
        }
        return null;
    }

    public String getAdditionalStatusMessage() {
        if(null != contextResponse){
            return (String) contextResponse.get("additionalStatusMessage");
        }
        return null;
    }


    public String getAdditionalStatusCode() {
        if(null != contextResponse){
            return (String) contextResponse.get("additionalStatusCode");
        }
        return null;
    }

    public String getStatusMessage() {
        if(null != contextResponse){
            return (String) contextResponse.get("statusMessage");
        }
        return null;
    }

    public String getTenantName() {
        if(null != contextResponse){
            return (String) contextResponse.get("tenantName");
        }
        return null;
    }


}
