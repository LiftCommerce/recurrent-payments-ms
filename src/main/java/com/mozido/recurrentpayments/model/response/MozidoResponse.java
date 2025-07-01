package com.mozido.recurrentpayments.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Rafael Richards on 06/25.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class MozidoResponse {
    private LinkedHashMap contextResponse;
    private LinkedHashMap confirmationInfo;
    private LinkedHashMap transactionInfo;
    private LinkedHashMap responseData;
    private Map details;
    private String detail;
    private String errors;
    private String id;
    private String status;

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

    public LinkedHashMap getTransactionInfo() {
        return transactionInfo;
    }

    public void setTransactionInfo(LinkedHashMap transactionInfo) {
        this.transactionInfo = transactionInfo;
    }

    public void setDetails(Map details) {
        this.details = details;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public LinkedHashMap getResponseData() {
        return responseData;
    }

    public void setResponseData(LinkedHashMap responseData) {
        this.responseData = responseData;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getStatusCode() {
        if(null != contextResponse){
            return (String) contextResponse.get("statusCode");
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

    public String getAdditionalStatusMessage() {
        if(null != contextResponse){
            return (String) contextResponse.get("additionalStatusMessage");
        }
        return null;
    }

    public LinkedHashMap getErrors() {
        if(null != contextResponse){
            return (LinkedHashMap) contextResponse.get("errors");
        }
        return null;
    }

    public String getTenantName() {
        if(null != contextResponse){
            return (String) contextResponse.get("tenantName");
        }
        return null;
    }

    public String getConfirmationDate() {
        if(null != confirmationInfo){
            return (String) confirmationInfo.get("confirmationDate");
        }
        return null;
    }

    public String getConfirmationId() {
        if(null != confirmationInfo){
            return (String) confirmationInfo.get("confirmationId");
        }
        return null;
    }

    public String getTimeStamp() {
        if(null != transactionInfo){
            return (String) transactionInfo.get("timeStamp");
        }
        return null;
    }

    public String getTransactionId() {
        if(null != transactionInfo){
            return (String) transactionInfo.get("transactionId");
        }
        return null;
    }

    public String getUserId(){
        if(null != responseData){
            return (String) responseData.get("id");
        }
        return null;
    }

    public Map<String, Object> getDetails() {
        if(null == details){
            if(null != transactionInfo){
                details = new HashMap<String, Object>();
                List<Map> detailsArr = (List<Map>) transactionInfo.get("details");
                for(Map map: detailsArr){
                    details.put(map.get("key"), map.get("value"));
                }
                return details;
            }
        } else {
            return details;
        }

        return null;
    }

    public String getDetail() {
        return detail;
    }

    @Override
    public String toString() {
        return "MozidoResponse{" +
                "contextResponse=" + contextResponse +
                ", confirmationInfo=" + confirmationInfo +
                ", transactionInfo=" + transactionInfo +
                ", errors='" + errors + '\'' +
                '}';
    }
}
