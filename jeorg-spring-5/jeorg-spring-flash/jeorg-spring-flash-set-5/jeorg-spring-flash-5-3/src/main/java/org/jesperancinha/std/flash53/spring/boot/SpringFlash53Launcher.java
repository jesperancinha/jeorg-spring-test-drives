package org.jesperancinha.std.flash53.spring.boot;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.lang.annotation.Annotation;
import java.util.Arrays;
import java.util.stream.Collectors;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_GREEN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BRIGHT_WHITE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash53Launcher implements CommandLineRunner {
    public static void main(String[] args) {
        GREEN.printGenericTitleLn("Service is starting");
        SpringApplication.run(SpringFlash53Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        ConsolerizerComposer.out(" ")
                .yellow("The @SpringBootAnnotation is composed of a lot of other annotations")
                .newLine()
                .green("These are:")
                .newLine()
                .brightGreen(Arrays.stream(this.getClass().getAnnotations())
                        .map(Annotation::annotationType)
                        .map(Class::getAnnotations)
                        .collect(Collectors.toList()))
                .toConsoleLn();

        Arrays.stream(this.getClass().getAnnotations()).forEach(annotation ->
        {
            BRIGHT_BLUE.printGenericLn(annotation);
            Arrays.stream(annotation.annotationType().getAnnotations())
                    .forEach(annotation1 -> {
                        BRIGHT_GREEN.printGenericLn(annotation1);
                        Arrays.stream(annotation1.annotationType().getAnnotations())
                                .forEach(BRIGHT_WHITE::printGenericLn);
                    });
        });
    }

}