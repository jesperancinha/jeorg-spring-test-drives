package org.jesperancinha.std.action.actuator;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeorgActionActuatorLauncher implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionActuatorLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
    }
}
