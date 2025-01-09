package com.example.ss_2025_l1_ex1.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

//@Configuration
public class ProjectConfig {

    private final CustomAuthenticationProvider authenticationProvider;

    public ProjectConfig(CustomAuthenticationProvider authenticationProvider) {
        this.authenticationProvider = authenticationProvider;
    }

    SecurityFilterChain configure(HttpSecurity http)
            throws Exception {
        http.httpBasic(Customizer.withDefaults());

        http.authenticationProvider(authenticationProvider);

        http.authorizeHttpRequests(
                c->c.anyRequest()
                        .authenticated()
        );

        return http.build();

    }



    /*
    @Bean
    UserDetailsService userDetailsService(){
        var user = User.withUsername("Lucas")
                .password("123456")
                .roles("read")
                .build();
        return new InMemoryUserDetailsManager(user);
    }


    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }

    */

    /*
    //Defining a SecurityFilterChain bean
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {

        http.httpBasic(Customizer.withDefaults());

        http.authorizeHttpRequests(
                c->c.anyRequest().authenticated()
        );

        //Setting UserDetailsService with the SecurityFilterChain bean
        var user = User.withUsername("john")
                .password("12345")
                .roles("read")
                .build();

        var userDetailsService = new InMemoryUserDetailsManager(user);

        http.userDetailsService(userDetailsService);

        return http.build();
    }

    @Bean
    PasswordEncoder passwordEncoder(){
        return NoOpPasswordEncoder.getInstance();
    }
    */
}
