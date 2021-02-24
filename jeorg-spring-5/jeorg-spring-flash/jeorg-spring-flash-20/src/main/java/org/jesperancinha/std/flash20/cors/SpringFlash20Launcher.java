package org.jesperancinha.std.flash20.cors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.lang.NonNull;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class SpringFlash20Launcher {
    public static void main(String[] args) {
        SpringApplication.run(SpringFlash20Launcher.class, args);
    }
}
