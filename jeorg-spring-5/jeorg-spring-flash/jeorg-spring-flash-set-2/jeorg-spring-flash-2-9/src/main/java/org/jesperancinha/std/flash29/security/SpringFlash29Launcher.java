package org.jesperancinha.std.flash29.security;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.jesperancinha.std.flash29.security.services.JewelType;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SpringFlash29Launcher implements CommandLineRunner {

    private final JewelRepository jewelRepository;

    public SpringFlash29Launcher(JewelRepository jewelRepository) {
        this.jewelRepository = jewelRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash29Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final Jewel jewel = new Jewel();
        jewel.setJewelType(JewelType.AMETHYST);
        jewel.setGuardian("admin");
        jewelRepository.save(jewel);
    }
}
