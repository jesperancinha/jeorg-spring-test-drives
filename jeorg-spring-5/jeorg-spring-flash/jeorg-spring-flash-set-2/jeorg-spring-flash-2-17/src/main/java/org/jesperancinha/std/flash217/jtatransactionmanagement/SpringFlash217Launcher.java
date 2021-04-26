package org.jesperancinha.std.flash217.jtatransactionmanagement;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash217.jtatransactionmanagement.domain.Marble;
import org.jesperancinha.std.flash217.jtatransactionmanagement.service.MarbleDao;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash217Launcher implements CommandLineRunner {

    private final MarbleDao marbleDao;

    public SpringFlash217Launcher(MarbleDao marbleDao) {
        this.marbleDao = marbleDao;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash217Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        marbleDao.createTables();
        final Marble marble1 = marbleDao.create("Lucky Charm", "red");
        marbleDao.resetDatabase();
        final Marble marble2 = marbleDao.createRollback("Lucky Charm", "red");
        marbleDao.resetDatabase();
        final Marble marble3 = marbleDao.createFailRollback("Lucky Charm", "red");
        marbleDao.resetDatabase();
        final Marble marble4 = marbleDao.createNoTransaction("Lucky Charm", "red");
        ConsolerizerComposer.outSpace()
                .green("Marbles")
                .green("MARBLE_TEST1 - Normal")
                .red().jsonPrettyPrint(marble1)
                .green("MARBLE_TEST2 - Rollback")
                .red().jsonPrettyPrint(marble2)
                .green("MARBLE_TEST3 - Rollback Fail")
                .red().jsonPrettyPrint(marble3)
                .green("MARBLE_TEST4 - No Commit / No Rollback")
                .red().jsonPrettyPrint(marble4)
                .green("MARBLE_TESTN - Final List!")
                .jsonPrettyPrint(marbleDao.listMarbles())
                .reset();
    }
}
