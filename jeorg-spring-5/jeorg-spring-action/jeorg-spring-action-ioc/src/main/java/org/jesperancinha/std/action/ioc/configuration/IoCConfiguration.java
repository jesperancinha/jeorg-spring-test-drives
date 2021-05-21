package org.jesperancinha.std.action.ioc.configuration;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.action.ioc.model.Cutlery;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    public void perform(
            @Value("${org.jesperancinha.std.action.ioc.cutlery}")
            final String allCutlery) {
        ConsolerizerComposer.outSpace()
                .blue("This is directly done via initialization")
                .blue(allCutlery)
                .reset();
    }

    @Value("${org.jesperancinha.std.action.ioc.cutlery}")
    public void perform2(final String allCutlery) {
        ConsolerizerComposer.outSpace()
                .blue("This is directly done via initialization2")
                .blue(allCutlery)
                .reset();
    }
}
