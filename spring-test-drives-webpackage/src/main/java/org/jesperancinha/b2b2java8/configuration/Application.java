package org.jesperancinha.b2b2java8.configuration;

import org.jesperancinha.b2b2java8.predicates.withchangeinpredicate.SomethingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by joao on 14-5-16.
 */
@Configuration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
@ComponentScan("org.jesperancinha.b2b2java8.predicates")
public class Application {

    @Bean
    public SomethingService somethingService() {
        return new SomethingService();
    }
}
