package org.jesperancinha.std.mastery2.portuguese.music.configuration;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

public class Mastery2ConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/portuguese/antonio").hasRole("ADMIN")
                .mvcMatchers("/portuguese/antonio")
                .authenticated()
                .antMatchers("/portuguese")
                .permitAll()
                .and()
                .formLogin();

        GREEN.printGenericLn("Note that ADMIN in this case is a short statement for ROLE_ADMIN");
        GREEN.printGenericLn("When we assign our SimpleGrantedAuthority to our Authentication, we give it a role as parameter");
        GREEN.printGenericLn("The role is an extended name. In our case it will be ROLE_ADMIN");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) {
        builder.authenticationProvider(new Mastery2AuthenticationProvider());
    }
}
