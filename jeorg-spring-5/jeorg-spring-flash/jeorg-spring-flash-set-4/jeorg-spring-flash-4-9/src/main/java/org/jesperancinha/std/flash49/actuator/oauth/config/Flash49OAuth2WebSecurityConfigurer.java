package org.jesperancinha.std.flash49.actuator.oauth.config;

import org.jesperancinha.std.flash49.actuator.oauth.service.Flash49UserDetailsService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
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
public class Flash49OAuth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;

    private final Flash49UserDetailsService flash49UserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public Flash49OAuth2WebSecurityConfigurer(AuthenticationProvider authenticationProvider, Flash49UserDetailsService flash49UserDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.flash49UserDetailsService = flash49UserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(flash49UserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .authenticationProvider(authenticationProvider)
                .eraseCredentials(false);
    }

}