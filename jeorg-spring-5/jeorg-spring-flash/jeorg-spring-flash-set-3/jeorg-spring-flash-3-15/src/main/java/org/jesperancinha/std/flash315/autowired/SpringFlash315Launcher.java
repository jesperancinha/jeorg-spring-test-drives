package org.jesperancinha.std.flash315.autowired;

import org.jesperancinha.std.flash315.autowired.domain.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;

@SpringBootApplication
public class SpringFlash315Launcher implements CommandLineRunner {

    @Autowired(required = false)
    private Something something;

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash315Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        BRIGHT_BLUE.printGenericLn("If you reached this and something is not null, it means that you are running profile test. Congratulations!");
        BRIGHT_BLUE.printGenericLn(something);
    }
}