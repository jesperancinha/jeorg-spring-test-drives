package org.jesperancinha.b2b2java8.configuration;

import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.PredicateConfiguration;
import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.PredicateMain;
import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.SomethingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ApplicationOkTestConfiguration {

    @Bean
    PredicateMain predicateMain() {
        return new PredicateMain();
    }

    @Bean
    SomethingService somethingService() {
        return new SomethingService();
    }

    @Bean
    PredicateConfiguration predicateConfiguration() {
        return new PredicateConfiguration();
    }

}
