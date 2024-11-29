package org.jesperancinha.std.flash219.beans.configuration;

import jakarta.annotation.PreDestroy;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash219.beans.domain.Nut;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BROWN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {NutsConfiguration.class, NutsMethodsConfigurationTest.NutsTestConfiguration.class})
class NutsMethodsConfigurationTest {

    @Autowired
    public Nut almond;

    @MockitoBean
    public static NutExtended nutExtended;

    @Autowired
    public ApplicationContext applicationContext;

    @Test
    void almond() {
        ConsolerizerComposer.outSpace()
                .orange(almond)
                .orange(nutExtended)
                .reset();

        verify(nutExtended, times(1)).initiate();
    }

    @Configuration
    public static class NutsTestConfiguration {

        @Bean
        @Primary
        @Qualifier("nut")
        public NutExtended nut() {
            return new NutExtended();
        }

        @PreDestroy
        public void check() {
            verify(nutExtended, times(1)).goToCake();
        }
    }

    @Configuration
    public static class NutExtended extends Nut {

        public void goToCake() {
            BROWN.printGenericLn("Going to cake...");
        }


        public void initiate() {
            ORANGE.printGenericLn("Creating %s", toString());
        }
    }
}