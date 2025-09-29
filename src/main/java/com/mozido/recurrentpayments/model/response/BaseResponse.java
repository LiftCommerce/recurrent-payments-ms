package com.mozido.recurrentpayments.model.response;

import io.swagger.v3.oas.annotations.media.Schema;
import org.springframework.http.HttpStatus;


public class BaseResponse {

    @Schema(description = "Status Code")
    private HttpStatus statusCode = HttpStatus.OK;

    @Schema(description = "HttpCode")
    private Integer code = 200;

    @Schema(description = "Response Message")
    private String msg = "Success";

    public HttpStatus getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatus statusCode) {
        this.statusCode = statusCode;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
