package com.mozido.recurrentpayments.model.response;

import java.util.List;
import java.util.Map;

public class ApiPaginatedResponse<T> {
    private String statusCode;
    private int code;
    private String msg;
    private List<T> data;
    private Map<String, Object> meta;

    public ApiPaginatedResponse(String statusCode, int code, String msg, List<T> data, Map<String, Object> meta) {
        this.statusCode = statusCode;
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.meta = meta;
    }

    public static <T> ApiPaginatedResponse<T> ok(List<T> data, Map<String, Object> meta) {
        return new ApiPaginatedResponse<>("OK", 200, "Success", data, meta);
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, Object> getMeta() {
        return meta;
    }

    public void setMeta(Map<String, Object> meta) {
        this.meta = meta;
    }
}