package com.mozido.recurrentpayments.model;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtException;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.util.List;

/**
 * Created by Rafael Richards on 06/25.
 */

public class MozidoToken {

    private String uuid;
    private String tenantName;
    private String username;
    private Integer exp;
    private List authorities;
    private Object needChangePassword;


    public MozidoToken(Claims body) throws ExpiredJwtException, JwtException, NoSuchAlgorithmException,
            InvalidKeySpecException, ClassCastException {
        if (body != null && body.get("tenant_name") != null) {
            setTenantName((String) body.get("tenant_name"));
        }
        if (body != null && body.get("user_name") != null) {
            setUserName((String) body.get("user_name"));
        }
        if (body != null && body.get("exp") != null) {
            setExp((Integer) body.get("exp"));
        }
        if (body != null && body.get("authorities") != null) {
            setAuthorities((List) body.get("authorities"));
        }
        if (body != null && body.get("uuid") != null) {
            setUuid((String) body.get("uuid"));
        }
        if (body != null && body.get("need_change_password") != null) {
            setNeedChangePassword(body.get("need_change_password"));
        }
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getTenantName() {
        return tenantName;
    }

    public void setTenantName(String tenantName) {
        this.tenantName = tenantName;
    }

    public String getUsername() {
        return username;
    }

    public void setUserName(String username) {
        this.username = username;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public List getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List authorities) {
        this.authorities = authorities;
    }

    public Object getNeedChangePassword() {
        return needChangePassword;
    }

    public void setNeedChangePassword(Object needChangePassword) {
        this.needChangePassword = needChangePassword;
    }
}
