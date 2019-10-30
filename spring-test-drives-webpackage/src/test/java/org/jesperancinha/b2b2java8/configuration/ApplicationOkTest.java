package org.jesperancinha.b2b2java8.configuration;

import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.PredicateConfiguration;
import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.PredicateMain;
import org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate.SomethingService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by joao on 14-5-16.
 */
@Configuration
@ContextConfiguration(loader = AnnotationConfigContextLoader.class)
public class ApplicationOkTest {

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
