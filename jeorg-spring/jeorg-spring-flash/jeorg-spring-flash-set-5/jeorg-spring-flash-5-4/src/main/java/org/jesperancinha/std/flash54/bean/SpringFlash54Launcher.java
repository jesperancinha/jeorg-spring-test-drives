package org.jesperancinha.std.flash54.bean;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash54Launcher implements CommandLineRunner {

    public static void main(String[] args) {
        GREEN.printGenericTitleLn("Service is starting");
        SpringApplication.run(SpringFlash54Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        ConsolerizerComposer
                .out(" ")
                .red("Our tomato has grown 🍅")
                .newLine()
                .red("And now we eat it!")
                .newLine()
                .magenta("Please stop the server to see that in action")
                .toConsoleLn();
    }

}