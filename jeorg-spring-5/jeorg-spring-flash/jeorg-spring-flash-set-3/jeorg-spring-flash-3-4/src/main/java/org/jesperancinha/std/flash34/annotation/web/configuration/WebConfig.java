package org.jesperancinha.std.flash34.annotation.web.configuration;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"org.jesperancinha.std.flash34.annotation.web.controller"})
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void configureDefaultServletHandling(
            DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

//	@Bean
//	public InternalResourceViewResolver configureInternalResourceViewResolver() {
//		InternalResourceViewResolver internalResourceViewResolver = new InternalResourceViewResolver();
//		internalResourceViewResolver.setPrefix("/WEB-INF/views/");
//		internalResourceViewResolver.setSuffix(".jsp");
//		return internalResourceViewResolver;
//	}
}
