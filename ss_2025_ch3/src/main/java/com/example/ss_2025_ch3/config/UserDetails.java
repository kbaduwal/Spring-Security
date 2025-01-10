package com.example.ss_2025_ch3.config;

import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Collection;

//The UserDetails interface is the contract you use to describe a user in Spring Security
public interface UserDetails extends Serializable {

    //These methods return the user credentials.
    String getUsername();
    String getPassword();

    //Returns the actions that the app allows the user to do as a collection of GrantedAuthority instances
    Collection<? extends GrantedAuthority> getAuthorities();

    //These four methods enable or disable the account for different reasons.
    boolean isAccountNonExpired();
    boolean isAccountNonLocked();
    boolean isCredentialsNonExpired();
    boolean isEnabled();
}
