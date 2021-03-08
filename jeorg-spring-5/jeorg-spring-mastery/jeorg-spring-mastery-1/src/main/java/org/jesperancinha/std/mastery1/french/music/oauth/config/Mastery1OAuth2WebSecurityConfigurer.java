package org.jesperancinha.std.mastery1.french.music.oauth.config;

import org.jesperancinha.std.mastery1.french.music.oauth.service.Mastery1UserDetailsService;
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
public class Mastery1OAuth2WebSecurityConfigurer extends WebSecurityConfigurerAdapter {

    private final AuthenticationProvider authenticationProvider;

    private final Mastery1UserDetailsService mastery1UserDetailsService;

    private final PasswordEncoder passwordEncoder;

    public Mastery1OAuth2WebSecurityConfigurer(AuthenticationProvider authenticationProvider, Mastery1UserDetailsService mastery1UserDetailsService, PasswordEncoder passwordEncoder) {
        this.authenticationProvider = authenticationProvider;
        this.mastery1UserDetailsService = mastery1UserDetailsService;
        this.passwordEncoder = passwordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(mastery1UserDetailsService)
                .passwordEncoder(passwordEncoder)
                .and()
                .authenticationProvider(authenticationProvider)
                .eraseCredentials(false);
    }

}