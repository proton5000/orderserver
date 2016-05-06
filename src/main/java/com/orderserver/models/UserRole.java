package com.orderserver.models;

import org.springframework.security.core.GrantedAuthority;

/**
 * Created by proton on 04.04.2016.
 */

public enum UserRole implements GrantedAuthority {

    USER("ROLE_ADMIN"),
    ADMIN("ROLE_USER");

    private String authority;

    UserRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return this.authority;
    }
}
