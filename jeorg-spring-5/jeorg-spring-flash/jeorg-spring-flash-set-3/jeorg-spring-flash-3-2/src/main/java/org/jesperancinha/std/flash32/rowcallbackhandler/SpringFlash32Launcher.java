package org.jesperancinha.std.flash32.rowcallbackhandler;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;
import java.sql.SQLException;

@SpringBootApplication
@RestController
public class SpringFlash32Launcher implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SpringFlash32Launcher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash32Launcher.class, args);
    }

    @Override
    public void run(String... args) {
        jdbcTemplate.execute("CREATE TABLE WHEN(\n" +
                "   ID   INT NOT NULL AUTO_INCREMENT,\n" +
                "   ARTIST VARCHAR(255) NOT NULL,\n" +
                "   WHEN VARCHAR(255) NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");");

        jdbcTemplate.update("INSERT INTO WHEN(ARTIST, WHEN) VALUES (?, ?)" , "The Doors", "The Music's Over");
        jdbcTemplate.update("INSERT INTO WHEN(ARTIST, WHEN) VALUES (?, ?)" , "Green Day", "I come around");

        jdbcTemplate.query("SELECT * FROM WHEN", new RowCallbackHandler() {
            @Override
            public void processRow(ResultSet rs) throws SQLException {
                ConsolerizerColor.MAGENTA.printGenericLn(
                        "The artist -> %s when -> %s", rs.getString("Artist"),rs.getString("When"));
            }
        });

    }


}
