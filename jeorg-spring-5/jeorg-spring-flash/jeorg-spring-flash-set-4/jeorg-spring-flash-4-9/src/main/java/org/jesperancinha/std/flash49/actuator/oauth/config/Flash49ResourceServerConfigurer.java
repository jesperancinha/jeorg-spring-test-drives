package org.jesperancinha.std.flash49.actuator.oauth.config;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.actuate.audit.InMemoryAuditEventRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class Flash49ResourceServerConfigurer extends ResourceServerConfigurerAdapter {

    private static final String RESOURCE_ID = "resource_id";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {
        resources.resourceId(RESOURCE_ID)
            .stateless(false);
    }

    @Bean
    public InMemoryAuditEventRepository repository(){
        final InMemoryAuditEventRepository inMemoryAuditEventRepository = new InMemoryAuditEventRepository();
        ConsolerizerComposer.out(" ")
                .magenta("Initializing bean")
                .blue(inMemoryAuditEventRepository)
                .toConsoleLn();
        ConsolerizerComposer.out(" ")
                .green("An event repository is always needed. Exposing the auditevents endpoints")
                .yellow("makes no sense if we don't keep the events somewhere")
                .toConsoleLn();
        return inMemoryAuditEventRepository;
    }

    @Override
    public void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
            .antMatchers("/open/**")
            .permitAll()
            .mvcMatchers( "/auditevents/**")
            .permitAll()
            .mvcMatchers("/concerts/**")
            .authenticated()
            .and()
            .exceptionHandling()
            .accessDeniedHandler(new OAuth2AccessDeniedHandler());
    }

}