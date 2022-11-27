package org.jesperancinha.std.flash49.actuator.oauth.config;

import org.jesperancinha.std.flash49.actuator.oauth.service.Flash49UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true)
public class Flash49OAuth2WebSecurityConfigurer {

    private final AuthenticationProvider authenticationProvider;

    private final Flash49UserDetailsService flash49UserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public Flash49OAuth2WebSecurityConfigurer(AuthenticationProvider authenticationProvider, Flash49UserDetailsService flash49UserDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.flash49UserDetailsService = flash49UserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http.userDetailsService(flash49UserDetailsService)
                .authenticationProvider(authenticationProvider)
                .build();
    }

}