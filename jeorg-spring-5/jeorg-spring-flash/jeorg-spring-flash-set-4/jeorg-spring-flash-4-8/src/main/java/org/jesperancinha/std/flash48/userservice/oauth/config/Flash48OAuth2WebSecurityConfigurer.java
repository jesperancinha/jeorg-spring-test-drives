package org.jesperancinha.std.flash48.userservice.oauth.config;

import org.jesperancinha.std.flash48.userservice.oauth.service.Flash48UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true,
        securedEnabled = true)
public class Flash48OAuth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;

    private final Flash48UserDetailsService flash48UserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public Flash48OAuth2WebSecurityConfigurer(AuthenticationProvider authenticationProvider, Flash48UserDetailsService flash48UserDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.flash48UserDetailsService = flash48UserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(flash48UserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .authenticationProvider(authenticationProvider)
                .eraseCredentials(false);
    }

}