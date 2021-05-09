package org.jesperancinha.std.flash54.bean;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.annotation.PreDestroy;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {
        SpringFlash54ConfigurationTest.TestTomatoConfiguration.class,
        SpringFlash54Configuration.class
})
class SpringFlash54ConfigurationTest {

    @SpyBean(TomatoExtended.class)
    private static TomatoExtended originalTomato;

    @Test
    void testTomatoWhenTomatoInitsAndEndsThenInitAndEndMethodsCalled() {
        verify(originalTomato, times(1)).growTomato();
    }

    public static class TomatoExtended extends Tomato {

        public TomatoExtended(String description) {
            super(description);
        }

        public void growTomato() {
        }

        public void eatTomato() {

        }

        @PreDestroy
        public void preDestroy() {
            verify(originalTomato, times(1)).eatTomato();
        }
    }

    @Configuration
    public static class TestTomatoConfiguration {

        @Bean
        public TomatoExtended originalTomato() {
            return new TomatoExtended("This is a test tomato");
        }
    }
}