package com.example.ss_2025_l1_ex1.config;

import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Component;

import java.util.Arrays;

/*The AuthenticationProvider implements the authentication logic.
It receives the request from the AuthenticationManager and
delegates finding the user to a UserDetailsService, verifying the password to a PasswordEncoder.*/

//@Component
public class CustomAuthenticationProvider implements AuthenticationProvider {

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        // authentication logic here
        String username =authentication.getName();
        String password = String.valueOf(authentication.getCredentials());

        if("john".equals(username) && "12345".equals(password)) {
            return new UsernamePasswordAuthenticationToken(
                    username,
                    password,
                    Arrays.asList());
        }else {
            throw new
                    AuthenticationCredentialsNotFoundException("Error");
        }

    }

    @Override
    public boolean supports(Class<?> authenticationTye) {
        // type of the Authentication implementation here

        return UsernamePasswordAuthenticationToken
                .class
                .isAssignableFrom(authenticationTye);
    }
}
