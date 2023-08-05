package com.catchypet.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.catchypet.service.UserService;

@Configurable
@EnableWebSecurity
public class WebSecurityConfig{

    @Autowired
    UserService userService;
    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/", "/login", "register").permitAll() // Permit all users create users
                        .requestMatchers("/buyers/**").hasAuthority("ROLE_BUYER") // Restrict buyers endpoints to only the buyer role
                        .requestMatchers("/sellers/**").hasAuthority("ROLE_SELLER") // Restrict sellers endpoints to only the seller role
                );
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
