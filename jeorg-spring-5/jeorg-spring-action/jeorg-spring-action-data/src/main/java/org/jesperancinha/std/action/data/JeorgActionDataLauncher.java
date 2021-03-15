package org.jesperancinha.std.action.data;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;

import java.sql.Connection;
import java.sql.PreparedStatement;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootApplication
public class JeorgActionDataLauncher implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;

    public JeorgActionDataLauncher(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public static void main(String[] args) {
        SpringApplication.run(JeorgActionDataLauncher.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        final var dataSource = jdbcTemplate.getDataSource();
        ConsolerizerComposer
                .outSpace()
                .blue(title("Examining data sources. What do you do and what does the template/Spring does?"))
                .magenta("Check https://docs.spring.io/spring-framework/docs/5.3.x/reference/html/data-access.html#jdbc for details");
        ConsolerizerComposer
                .outSpace()
                .cyan(title("1. Examining data sources. You define the data source"))
                .green("Take a look into application.properties")
                .yellow("You have defined this in order for Spring to create the DataSource")
                .green("The %s, does not create the %s", jdbcTemplate, dataSource)
                .yellow("You create the data source definition, but the %s itself is created by Spring", dataSource);


        assert dataSource != null;
        final Connection connection = dataSource.getConnection();
        ConsolerizerComposer
                .outSpace()
                .cyan(title("2. Opening the connection. Spring opens the connection"))
                .green("You've seen above how the %s is created", dataSource)
                .yellow("You did not intervene in anyway to create to create the %s", dataSource)
                .green("This is of course done seamlessly by Spring")
                .yellow("You create the data source definition, but the %s\nitself is created by Spring by means of the %s", connection, dataSource);

        final String query = "create table parasites(" +
                "name varchar(255)," +
                "quantity int" +
                ")";
        jdbcTemplate.execute(query);
        ConsolerizerComposer
                .outSpace()
                .cyan(title("3. Creating SQL statements. You create them!"))
                .green("Statements need to be defined by us")
                .yellow("The %s solely executes it", jdbcTemplate)
                .green("This is of course done seamlessly by Spring")
                .yellow("You create the \"%s\"\nwhich then gets executed by the %s\nby means of the %s\nwhich uses a %s\nto do it"
                        , query, jdbcTemplate, dataSource,connection);


    }
}
