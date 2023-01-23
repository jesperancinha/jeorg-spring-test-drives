package org.jesperancinha.std.flash3.persistence;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * This module doesn't do anything except running a spring boot raw service.
 * The idea is just to remind ourselves which dependencies are important for testing
 */
@SpringBootApplication
public class SpringFlash3Launcher implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash3Launcher.class, args);

    }

    @Override
    public void run(ApplicationArguments args) {

    }
}
