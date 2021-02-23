package org.jesperancinha.std.flash17.cipher.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

import javax.sql.DataSource;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerGraphs.printUnicornsLn;

@Configuration
@EnableWebMvc
public class Flash17MvcConfig implements WebMvcConfigurer {

    private final DataSource datasource;

    public Flash17MvcConfig(DataSource datasource) {
        this.datasource = datasource;
    }

    @Bean
    public ViewResolver getViewResolver() {
        InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
        internalResourceViewResolver.setViewClass(JstlView.class);
        internalResourceViewResolver.setPrefix("/WEB-INF/jsp/");
        internalResourceViewResolver.setSuffix(".jsp");
        BLUE.printGenericLn("Initializing viewResolver -> %s", internalResourceViewResolver);
        printUnicornsLn(100);
        BRIGHT_MAGENTA.printGenericLn("Remember that you need the jasper dependency for the JSP Mapping to work");
        return internalResourceViewResolver;
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return PasswordEncoderFactories.createDelegatingPasswordEncoder();
    }

    @Bean
    public JdbcUserDetailsManager jdbcUserDetailsManager() {
        return new JdbcUserDetailsManager(datasource);
    }


}
