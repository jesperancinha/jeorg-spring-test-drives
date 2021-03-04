package org.jesperancinha.std.flash312.query;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.IncorrectResultSizeDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@SpringBootApplication
public class SpringFlash312Launcher implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public SpringFlash312Launcher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash312Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        jdbcTemplate.execute("CREATE TABLE rancid_objects(\n" +
                "ID INT NOT NULL AUTO_INCREMENT,\n" +
                "NAME VARCHAR(255) NOT NULL)");

        final List<Object[]> allRancidObjects = Arrays.asList(new Object[]{"Black Coat"}, new Object[]{"Black Shoes"}, new Object[]{"Black Hat"}, new Object[]{"Cadillac"});

        jdbcTemplate.batchUpdate("INSERT INTO rancid_objects (name) VALUES (?)", allRancidObjects);


        try {
            final RancidObject rancidObject = jdbcTemplate.queryForObject("SELECT * FROM rancid_objects", new RowMapper<RancidObject>() {
                @Override
                public RancidObject mapRow(ResultSet rs, int rowNum) throws SQLException {
                    ORANGE.printGenericLn("Row number is -> %s", rowNum);
                    ORANGE.printGenericLn("Name is -> %s", rs.getString("name"));
                    return new RancidObject(rs.getString("name"));
                }
            });
        } catch (final IncorrectResultSizeDataAccessException incorrectResultSizeDataAccessException) {
            YELLOW.printExpectedException("We have returned all 4 rancid objects! This will not work for queryForObject", incorrectResultSizeDataAccessException);
        }

        final RancidObject rancidObject = jdbcTemplate.queryForObject("SELECT * FROM rancid_objects WHERE ID = 1", new RowMapper<RancidObject>() {
            @Override
            public RancidObject mapRow(ResultSet rs, int rowNum) throws SQLException {
                ORANGE.printGenericLn("Row number is -> %s", rowNum);
                ORANGE.printGenericLn("Name is -> %s", rs.getString("name"));
                return new RancidObject(rs.getString("name"));
            }
        });

        final List<Map<String, Object>> maps = jdbcTemplate.queryForList("SELECT * FROM rancid_objects");
        MAGENTA.printGenericLn(rancidObject);
        BRIGHT_MAGENTA.printGenericLn(maps);
    }
}