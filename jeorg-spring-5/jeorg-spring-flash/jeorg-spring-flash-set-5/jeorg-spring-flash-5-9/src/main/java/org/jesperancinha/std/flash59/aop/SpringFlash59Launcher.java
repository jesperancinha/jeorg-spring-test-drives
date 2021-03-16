package org.jesperancinha.std.flash59.aop;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash59.aop.service.Recipe;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringFlash59Launcher implements CommandLineRunner {

    private final Recipe recipe;

    public SpringFlash59Launcher(Recipe recipe) {
        this.recipe = recipe;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash59Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        ConsolerizerComposer.outSpace()
                .newLine()
                .black()
                .bgYellow(recipe.bake())
                .reset();
        ConsolerizerComposer.outSpace()
                .newLine()
                .black()
                .bgYellow(recipe.bakeDiet())
                .reset();
    }
}
