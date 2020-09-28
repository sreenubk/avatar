package com.lotus.security.avatar.auth;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

public enum SecurityPermissions {

    READ("read"),
    WRITE("wite"),
    UPDATE("update"),
    DELETE("delete");

    private final String permission;

    SecurityPermissions(String permission){
        this.permission =permission;
    }

    public String getPermission() {
        return permission;
    }


}
