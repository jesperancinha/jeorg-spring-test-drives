package org.jesperancinha.std.action.ioc.configuration;

import org.jesperancinha.std.action.ioc.model.Cutlery;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class IoCConfiguration {

    @Bean
    public Cutlery cutlery(
            @Value("${org.jesperancinha.std.action.ioc.cutlery}")
            final String allCutlery) {
        return Cutlery
                .builder()
                .contents(allCutlery)
                .build();
    }
}
