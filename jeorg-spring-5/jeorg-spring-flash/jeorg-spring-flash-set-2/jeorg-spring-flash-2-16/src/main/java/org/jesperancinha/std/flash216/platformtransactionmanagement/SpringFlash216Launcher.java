package org.jesperancinha.std.flash216.platformtransactionmanagement;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;
import org.jesperancinha.std.flash216.platformtransactionmanagement.domain.Award;
import org.jesperancinha.std.flash216.platformtransactionmanagement.service.AwardDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;

@SpringBootApplication
public class SpringFlash216Launcher implements CommandLineRunner {

    @Autowired
    private AwardDao awardDao;

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash216Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        awardDao.createTables();
        final Award award = awardDao.create("Mylène Farmer", "World's Best Selling French Artist", LocalDateTime.of(1993, 5, 31, 12, 0, 0));
        GREEN.printGenericLn(award);
        BLUE.printGenericLn(awardDao.listAwards());
    }
}
