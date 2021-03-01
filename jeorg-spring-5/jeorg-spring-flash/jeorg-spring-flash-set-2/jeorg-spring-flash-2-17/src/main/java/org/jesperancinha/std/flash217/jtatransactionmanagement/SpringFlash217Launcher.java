package org.jesperancinha.std.flash217.jtatransactionmanagement;

import org.jesperancinha.std.flash217.jtatransactionmanagement.domain.Marble;
import org.jesperancinha.std.flash217.jtatransactionmanagement.service.MarbleDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash217Launcher  implements CommandLineRunner {

    private final MarbleDao marbleDao;

    public SpringFlash217Launcher(MarbleDao marbleDao) {
        this.marbleDao = marbleDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash217Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        marbleDao.createTables();
        final Marble marble = marbleDao.create("Lucky Charm", "red");
        GREEN.printGenericLn(marble);
        BLUE.printGenericLn(marbleDao.listMarbles());
    }
}
