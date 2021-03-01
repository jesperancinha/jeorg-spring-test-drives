package org.jesperancinha.std.flash218.profiles.configurations;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("garbage | pumpkin")
public class GarbageAndPumpkinConfig {
    public GarbageAndPumpkinConfig(){
        new GarbageConfig();
        new PumpkinsConfig();
    }
}
