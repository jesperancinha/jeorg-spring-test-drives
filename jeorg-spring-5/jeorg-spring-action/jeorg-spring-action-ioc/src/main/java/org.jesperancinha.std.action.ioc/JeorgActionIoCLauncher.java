package org.jesperancinha.std.action.ioc;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.action.ioc.interfaces.RestaurantInterface;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JeorgActionIoCLauncher implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionIoCLauncher.class, args);
    }

    @Override
    public void run(ApplicationArguments args) {
        RestaurantInterface.tutorialOne();
        RestaurantInterface.tutorialTwo();
        final RestaurantInterface.Table table = new RestaurantInterface.Table();
        ConsolerizerComposer.outSpace()
                .blue("We've create table %s", table)
                .reset();

        ConsolerizerComposer.outSpace()
                .magenta("We were able to create:")
                .magenta("1. Nested types")
                .magenta("2. Static methods")
                .reset();
    }
}
