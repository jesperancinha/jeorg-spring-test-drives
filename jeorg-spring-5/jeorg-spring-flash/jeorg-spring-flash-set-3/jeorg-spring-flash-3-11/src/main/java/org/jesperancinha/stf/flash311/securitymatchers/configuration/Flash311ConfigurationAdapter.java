package org.jesperancinha.stf.flash311.securitymatchers.configuration;

import org.jesperancinha.stf.flash311.securitymatchers.services.Flash311AuthenticationProvider;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@Configuration
@EnableWebSecurity
public class Flash311ConfigurationAdapter extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .mvcMatchers("/normal/**")
                .permitAll()
                .mvcMatchers(HttpMethod.GET, "/static/test.html")
                .authenticated()
                .mvcMatchers(HttpMethod.GET, "/static/index.html")
                .permitAll()
                .mvcMatchers("/admin/**").hasRole("RED")
                .antMatchers("/admin/**")
                .authenticated()
                .mvcMatchers("/user/**").hasRole("BLUE")
                .antMatchers("/user/**")
                .authenticated()
                .and()
                .formLogin().defaultSuccessUrl("/static/index.html", true);

        GREEN.printGenericLn("Note that RED in this case is a short statement for ROLE_RED");
        GREEN.printGenericLn("When we assign our SimpleGrantedAuthority to our Authentication, we give it a role as parameter");
        GREEN.printGenericLn("The role is an extended name. In our case it will be ROLE_RED");
        GREEN.printGenericLn("The same goes to all other roles like ROLE_BLUE");
    }

    @Override
    public void configure(AuthenticationManagerBuilder builder) {
        builder.authenticationProvider(new Flash311AuthenticationProvider());
    }
}