package org.jesperancinha.std.flash215.beanpostprocessor.configuration;

import org.jesperancinha.std.flash215.beanpostprocessor.bean.Cheese;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CheesesConfiguration {

    @Bean
    public Cheese camembert() {
        return new Cheese("Camembert", "https://en.wikipedia.org/wiki/Camembert");
    }

    @Bean
    public Cheese brie() {
        return new Cheese("Brie", "https://en.wikipedia.org/wiki/Brie");
    }

    @Bean
    public Cheese saoJorge() {
        return new Cheese("São Jorge", "https://en.wikipedia.org/wiki/S%C3%A3o_Jorge_cheese");
    }
}
