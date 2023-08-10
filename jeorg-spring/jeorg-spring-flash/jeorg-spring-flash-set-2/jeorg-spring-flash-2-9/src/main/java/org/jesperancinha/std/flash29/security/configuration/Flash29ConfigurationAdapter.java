package org.jesperancinha.std.flash29.security.configuration;

import org.jesperancinha.std.flash29.security.services.Flash29AuthenticationProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class Flash29ConfigurationAdapter {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        return http
                .authenticationProvider(new Flash29AuthenticationProvider())
                .authorizeRequests()
                .requestMatchers(new AntPathRequestMatcher("/**")).hasRole("ADMIN")
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .and()
                .csrf()
                .disable().build();
    }
}