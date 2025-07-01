package com.mozido.recurrentpayments.exception;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.mozido.recurrentpayments.model.Language;
import com.mozido.recurrentpayments.model.response.MozidoResponse;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {

    private Integer code;

    private HttpStatus status;
    private String message;
    private List<String> messages;
    private Language language;

    private String statusCode;
    private Object additionalStatusCode;
    private String statusMessage;
    private String additionalStatusMessage;
    private LinkedHashMap contextResponse;

    public ErrorResponse() {
    }

    public ErrorResponse(HttpStatus status, Integer code, String... messages) {
        this.setMessages(Arrays.asList(messages));
        this.setStatus(status);
        this.setCode(code);
    }

    public ErrorResponse(HttpStatus status, MozidoResponse mozidoResponse, Integer code, String... messages) {
        this(status, code, messages);
        this.setStatusCode(mozidoResponse.getStatusCode());
        this.setAdditionalStatusCode(mozidoResponse.getAdditionalStatusCode());
        this.setStatusMessage(mozidoResponse.getStatusMessage());
        this.setAdditionalStatusMessage(mozidoResponse.getAdditionalStatusMessage());
    }

    public ErrorResponse(HttpStatus status, MozidoResponse mozidoResponse, Integer code, Boolean tyk, String... messages) {
        this(status, code, messages);
        LinkedHashMap<String, Object> linkedHashMap = new LinkedHashMap();

        linkedHashMap.put("statusCode", mozidoResponse.getContextResponse().get("code"));
        linkedHashMap.put("additionalStatusCode", Integer.valueOf(mozidoResponse.getAdditionalStatusCode().toString()));
        linkedHashMap.put("statusMessage", mozidoResponse.getStatusMessage());
        linkedHashMap.put("additionalStatusMessage", mozidoResponse.getAdditionalStatusMessage());
        this.setContextResponse(linkedHashMap);
        /*this.setStatusCode(mozidoResponse.getStatusCode());
        this.setAdditionalStatusCode(mozidoResponse.getAdditionalStatusCode());
        this.setStatusMessage(mozidoResponse.getStatusMessage());
        this.setAdditionalStatusMessage(mozidoResponse.getAdditionalStatusMessage());*/
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @JsonIgnore
    public List<String> getMessages() {
        return messages;
    }

    public void setMessages(List<String> messages) {
        this.messages = messages;
    }

    @JsonIgnore
    public Language getLanguage() {
        return language;
    }

    public void setLanguage(Language language) {
        this.language = language;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public Object getAdditionalStatusCode() {
        return additionalStatusCode;
    }

    public void setAdditionalStatusCode(Object additionalStatusCode) {
        this.additionalStatusCode = additionalStatusCode;
    }

    public String getStatusMessage() {
        return statusMessage;
    }

    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }

    public String getAdditionalStatusMessage() {
        return additionalStatusMessage;
    }

    public void setAdditionalStatusMessage(String additionalStatusMessage) {
        this.additionalStatusMessage = additionalStatusMessage;
    }

    public LinkedHashMap getContextResponse() {
        return contextResponse;
    }

    public void setContextResponse(LinkedHashMap contextResponse) {
        this.contextResponse = contextResponse;
    }
}
