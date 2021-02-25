package org.jesperancinha.std.flash26.jdbc.handlers;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.std.flash26.jdbc.handlers.model.Shell;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.UncategorizedSQLException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.NonNull;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.Consolerizer.printRainbowTitleLn;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BLUE;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.GREEN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.MAGENTA;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.RED;

@SpringBootApplication
public class SpringFlash26Launcher implements CommandLineRunner {

    final JdbcTemplate jdbcTemplate;

    public SpringFlash26Launcher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(SpringFlash26Launcher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Consolerizer.setupFastDefault();
        try {
            jdbcTemplate.query("create table shells(id serial, name varchar(255), scientificName varchar(255), predominentColor varchar(255))"
                    , new ResultSetExtractor<String>() {
                        @Override
                        public String extractData(ResultSet rs) throws SQLException, DataAccessException {
                            return null;
                        }
                    });
        } catch (final UncategorizedSQLException uncategorizedSQLException) {
            RED.printExpectedException("This is an expected exception, because only queries are allowed. Although a create is sometimes referred to as a query, in this context, it must return results.", uncategorizedSQLException);
        }

        jdbcTemplate.execute("drop table shells if exists");
        jdbcTemplate.execute("create table shells(id serial, name varchar(255), scientificName varchar(255), predominentColor varchar(255))");

        jdbcTemplate.batchUpdate("insert into shells(name, scientificName, predominentColor) values (?,?,?)",
                Arrays.asList(
                        new Object[]{"Berbigão", "Cerastoderma edule", "white"},
                        new Object[]{"Conquilha", " Donax trunculus", "blue"}
                ));


        final String query = jdbcTemplate.query("select name, scientificName, predominentColor from shells"
                , new ResultSetExtractor<String>() {
                    @Override
                    public String extractData(
                            @NonNull
                                    ResultSet rs) throws SQLException, DataAccessException {
                        while (rs.next()) {
                            printRainbowTitleLn("The shell best known as %s, has a scientific name of %s and is mostly found with color %s",
                                    rs.getString("name"), rs.getString("scientificName"), rs.getString("predominentColor"));
                        }
                        return "OK!";
                    }
                });


        final List<Shell> allShells = jdbcTemplate.query("select name, scientificName, predominentColor from shells"
                , new RowMapper<Shell>() {
                    @Override
                    public Shell mapRow(ResultSet rs, int rowNum) throws SQLException {
                        GREEN.printGenericLn("The shell best known as %s, has a scientific name of %s and is mostly found with color %s",
                                rs.getString("name"), rs.getString("scientificName"), rs.getString("predominentColor"));

                        return new Shell(rs.getString("name"), rs.getString("scientificName"), rs.getString("predominentColor"));
                    }
                });

        BLUE.printGenericLn("All Shells -> %s", allShells);
        BLUE.printGenericTitleLn("The result is %s", query);
        MAGENTA.printGenericLn("Just like RowMapper, a ResultSetExtractor gives us the possibility to get all results");
        MAGENTA.printGenericLn("The Difference is that while RowMapper allows us to map a row to its index number from the result set, a ResultSetExtractor just returns the result set that we then have to iterate.");
    }
}
