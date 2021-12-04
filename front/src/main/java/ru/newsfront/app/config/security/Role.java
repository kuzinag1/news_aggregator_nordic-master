package ru.newsfront.app.config.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static ru.newsfront.app.config.security.Permission.*;

public enum Role {
    ADMIN(Sets.newHashSet(ADMIN_CREATE, ADMIN_READ, ADMIN_DELETE, ADMIN_UPDATE)),
    USER(Sets.newHashSet(USER_CREATE, USER_READ, USER_UPDATE, USER_DELETE));

    public final Set<Permission> permissionSet;

    Role(Set<Permission> permissionSet) {
        this.permissionSet = permissionSet;
    }

    public Set<Permission> getPermissionSet() {
        return permissionSet;
    }

    public Set<SimpleGrantedAuthority> getAuthorities() {
        return  getPermissionSet().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}

