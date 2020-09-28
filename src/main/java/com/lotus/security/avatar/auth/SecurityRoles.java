package com.lotus.security.avatar.auth;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public enum SecurityRoles {
    STUDENT(Sets.newHashSet()),
    ADMIN(Sets.newHashSet(SecurityPermissions.READ,SecurityPermissions.UPDATE,SecurityPermissions.WRITE,SecurityPermissions.DELETE)),
    OPT(Sets.newHashSet(SecurityPermissions.READ));



    private final Set<SecurityPermissions> permissions;

    SecurityRoles(Set<SecurityPermissions> permissions) {
        this.permissions = permissions;
    }

    public Set<SecurityPermissions> getPermissions() {
        return permissions;
    }

    public Set<GrantedAuthority> getGrantedAuthorities(){
        Set<GrantedAuthority> permissions = getPermissions().stream().map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add( new SimpleGrantedAuthority(String.format("ROLE_%s",this.name())));
        return permissions;
    }




}
