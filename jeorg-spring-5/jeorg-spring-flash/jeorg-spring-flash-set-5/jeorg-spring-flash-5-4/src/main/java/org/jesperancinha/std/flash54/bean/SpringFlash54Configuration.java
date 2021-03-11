package org.jesperancinha.std.flash54.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringFlash54Configuration {

    @Bean(initMethod = "growTomato", destroyMethod = "eatTomato")
    public Tomato tomato(){
        return new Tomato("This is a good tomato!");
    }
}
