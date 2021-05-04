package org.jesperancinha.std.flash55.hateoas;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.hateoas.Link;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@RestController
@SpringBootApplication
public class SpringFlash55Launcher implements CommandLineRunner {

    public static void main(String[] args) {
        GREEN.printGenericTitleLn("Service is starting");
        SpringApplication.run(SpringFlash55Launcher.class, args);
    }

    @Override
    public void run(String... args) {

    }

    @GetMapping("/")
    public ImmuneCells getAllCells(){
        final ImmuneCells immuneCells = new ImmuneCells();
        immuneCells.add(Link.of("/endless"));
        return immuneCells;
    }


    @GetMapping("/endless")
    public ImmuneCells getAllCellsEndless(){
        final ImmuneCells immuneCells = new ImmuneCells();
        immuneCells.add(Link.of("/"));
        return immuneCells;
    }
}
