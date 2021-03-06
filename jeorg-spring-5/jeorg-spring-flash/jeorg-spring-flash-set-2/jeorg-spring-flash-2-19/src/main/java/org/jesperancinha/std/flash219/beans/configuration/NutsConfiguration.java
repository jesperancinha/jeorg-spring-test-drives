package org.jesperancinha.std.flash219.beans.configuration;

import org.jesperancinha.std.flash219.beans.domain.Nut;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;

@Configuration
public class NutsConfiguration {

    @Bean(destroyMethod = "goToCake", initMethod = "initiate")
    public Nut almond() {
        final Nut nut = new Nut();
        nut.setName("Almond");
        BLUE.printGenericLn("Created %s", nut);
        return nut;
    }

}
