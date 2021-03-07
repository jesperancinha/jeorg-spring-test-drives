package org.jesperancinha.std.flash47.jdbc.resultset;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@RestController
@SpringBootApplication
public class SpringFlash47Launcher implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SpringFlash47Launcher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

    }

    public static void main(String[] args) {
        SpringApplication.run(new Class[]{SpringFlash47Launcher.class}, args);
    }

    @Override
    public void run(String... args) throws Exception {
        jdbcTemplate.execute("create table flowers(" +
                "ID int not null auto_increment," +
                "SPECIES VARCHAR(255)," +
                "AVAILABLE INT" +
                ")");

        jdbcTemplate.update("insert into flowers (species, available) values ( ?,? )", "tulip", 10);
        jdbcTemplate.update("insert into flowers (species, available) values ( ?,? )", "rose", 100);
        jdbcTemplate.update("insert into flowers (species, available) values ( ?,? )", "carnations", 1000);


        final String fullMessageStatus = jdbcTemplate.query("select * from flowers", new ResultSetExtractor<String>() {
            @Override
            public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                final var sb = new StringBuilder();
                while (rs.next()) {
                    sb.append(String.format("There are %d %s available\n",
                            rs.getInt("available"),
                            rs.getString("species")));
                }
                return sb.toString();
            }
        });

        ConsolerizerComposer.out(" ")
                .magenta("We got the flowers result from the database using")
                .green("ResultSetExtractor")
                .magenta("and here they are:")
                .newLine()
                .brightCyan(fullMessageStatus)
                .toConsoleLn();

    }
}
