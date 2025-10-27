package com.mozido.recurrentpayments.model.response;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class GetMyUserResponse extends BaseResponse {

    private UserResponseBorrar user;
    private String catholicDirectoryAccountNumber;
    private String parishName;
    private String parishionerId;

    public GetMyUserResponse() {}

    public GetMyUserResponse(UserResponseBorrar user) {
        this.user = user;
    }

    public UserResponseBorrar getUser() {
        return user;
    }

    public void setUser(UserResponseBorrar user) {
        this.user = user;
    }

    public String getCatholicDirectoryAccountNumber() {
        return catholicDirectoryAccountNumber;
    }

    public void setCatholicDirectoryAccountNumber(String catholicDirectoryAccountNumber) {
        this.catholicDirectoryAccountNumber = catholicDirectoryAccountNumber;
    }

    public String getParishName() {
        return parishName;
    }

    public void setParishName(String parishName) {
        this.parishName = parishName;
    }

    public String getParishionerId() {
        return parishionerId;
    }

    public void setParishionerId(String parishionerId) {
        this.parishionerId = parishionerId;
    }
}


