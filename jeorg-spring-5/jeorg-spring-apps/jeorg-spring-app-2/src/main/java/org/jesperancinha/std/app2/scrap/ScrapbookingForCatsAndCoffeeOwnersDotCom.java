package org.jesperancinha.std.app2.scrap;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootApplication
public class ScrapbookingForCatsAndCoffeeOwnersDotCom implements ApplicationRunner {
    public static void main(String[] args) {
        SpringApplication.run(ScrapbookingForCatsAndCoffeeOwnersDotCom.class, args);
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        ConsolerizerComposer.outSpace()
                .green(title("I. Codebase"))
                .blue("If you look at this whole repo, you will see many apps")
                .blue("This does not follow principle one of the 12 factor app")
                .blue("However, if this module was in a single repo with nothing but library dependencies,")
                .blue("it would still follow the 12 factor app principle.")
                .blue("This means that all of the applications in this module form distributed system.")
                .blue("At the same time, each individual app only has a codebase and that does follow the principle")
                .blue("Individually, they all follow principle I")
                .green(title("II. Dependencies"))
                .blue("This is essentially what the pom file is all about")
                .blue("In this repo, we use maven as a package dependency manager.")
                .green(title("III. Config"))
                .blue("In Spring applications such as the ones provided in this repo, configuration is provided by the use of application.properties files.")
                .blue("In our case a dash between application and a name will define properties exclusively applied to that profile.")
                .blue("This principle means that an application should have profile specific configurations, namely designated for develop, acceptance and productoion")
                .green(title("IV. Backing services"))
                .blue("In this application, all our data will be stored in memory in database app2.")
                .blue("The database we have configured in an H2 database.")
                .blue("However, if you notice closely in the code, there is no reference to third parties")
                .blue("Using Spring in this case allows us to create backing services which can be used regardless of what the third party providing the database is.")
                .green(title("V. Build, release, run"))
                .reset();
    }
}
