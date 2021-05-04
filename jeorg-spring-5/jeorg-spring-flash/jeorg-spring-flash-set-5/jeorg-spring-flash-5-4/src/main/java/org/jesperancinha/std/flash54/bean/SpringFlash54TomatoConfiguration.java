package org.jesperancinha.std.flash54.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFlash54TomatoConfiguration {
    @Bean
    public Tomato originalTomato() {
        return new Tomato("This is a good tomato!");
    }
}
