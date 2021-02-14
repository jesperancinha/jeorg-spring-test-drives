package org.jesperancinha.std.topic.container;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;

@SpringBootApplication
public class ContainerLauncher {
    public static void main(String[] args) {
        BRIGHT_MAGENTA.printGenericTitleLn("Service Started");
        GREEN.printGenericTitleLn("Spring Boot");
        SpringApplication.run(ContainerLauncher.class, args);
    }
}
