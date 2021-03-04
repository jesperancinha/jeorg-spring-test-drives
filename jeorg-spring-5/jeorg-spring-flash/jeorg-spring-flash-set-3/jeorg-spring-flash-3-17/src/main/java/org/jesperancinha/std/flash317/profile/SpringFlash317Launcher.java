package org.jesperancinha.std.flash317.profile;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFlash317Launcher implements CommandLineRunner {

    private final Messenger messenger;

    public SpringFlash317Launcher(Messenger messenger) {
        this.messenger = messenger;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash317Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ConsolerizerColor.BRIGHT_BLUE.printGenericLn(messenger);
    }
}