package com.example.ss_2025_ch3.config;

import java.io.Serializable;

//It represents a privilege granted to the user.
public interface GrantedAuthority extends Serializable {

    String getAuthority();
}
