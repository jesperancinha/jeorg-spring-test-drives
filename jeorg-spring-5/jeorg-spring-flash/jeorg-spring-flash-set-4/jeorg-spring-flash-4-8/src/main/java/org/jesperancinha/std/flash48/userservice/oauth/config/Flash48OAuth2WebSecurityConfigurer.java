package org.jesperancinha.std.flash48.userservice.oauth.config;

import org.jesperancinha.std.flash48.userservice.oauth.service.Flash48UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true)
public class Flash48OAuth2WebSecurityConfigurer {

    private final AuthenticationProvider authenticationProvider;

    private final Flash48UserDetailsService flash48UserDetailsService;

    public Flash48OAuth2WebSecurityConfigurer(AuthenticationProvider authenticationProvider, Flash48UserDetailsService flash48UserDetailsService) {
        this.authenticationProvider = authenticationProvider;
        this.flash48UserDetailsService = flash48UserDetailsService;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
      return   http.userDetailsService(flash48UserDetailsService)
                .authenticationProvider(authenticationProvider)
                .build();
    }

}