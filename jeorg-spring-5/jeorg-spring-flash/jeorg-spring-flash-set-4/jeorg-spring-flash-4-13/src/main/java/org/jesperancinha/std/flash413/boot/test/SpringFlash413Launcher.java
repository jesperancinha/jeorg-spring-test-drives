package org.jesperancinha.std.flash413.boot.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringFlash413Launcher {
    public static void main(String[] args) {
        final ConfigurableApplicationContext run = SpringApplication.run(new Class[]{SpringFlash413Launcher.class}, args);
    }
}