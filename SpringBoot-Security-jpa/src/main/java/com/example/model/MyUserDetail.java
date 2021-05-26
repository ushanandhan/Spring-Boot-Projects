package com.example.model;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class MyUserDetail implements UserDetails {

    private String username;
    private String password;
    private boolean isActive;
    private List<GrantedAuthority> authorities;

    public MyUserDetail() {
    }

    public MyUserDetail(User user) {
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.isActive = user.isActive();
        this.authorities = user.getRoles().stream()
                .map(role -> {
                    return new SimpleGrantedAuthority(role.getName());
                }).collect(Collectors.toList());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return isActive;
    }
}
