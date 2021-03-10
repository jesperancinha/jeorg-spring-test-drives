package org.jesperancinha.std.flash415.http.converter;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@SpringBootApplication
public class SpringFlash415Launcher implements CommandLineRunner {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash415Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

    }
}