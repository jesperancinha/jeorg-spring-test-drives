package org.jesperancinha.std.action.data;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCallback;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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
                        , query, jdbcTemplate, dataSource, connection);


        final String query2 = "insert into parasites(name, quantity)values(?,?)";
        final PreparedStatementCallback<String> preparedStatementCallback = new PreparedStatementCallback<>() {
            @Override
            public String doInPreparedStatement(PreparedStatement ps) throws SQLException, DataAccessException {
                ps.setString(1, "Ophiocordyceps");
                ps.setLong(1, 1000);
                return "Ok";
            }
        };
        final String execute = jdbcTemplate.execute(query2, preparedStatementCallback);
        ConsolerizerComposer
                .outSpace()
                .cyan(title("4. Preparing and executing SQL statements. Spring prepares and executes them!"))
                .green("Statements need to be defined by us, but Spring prepares them and executes them!")
                .yellow("When we define a %s", jdbcTemplate)
                .green("We can then execute the query")
                .yellow("In the inner workings of the execution, our query %s"
                        , query2)
                .green("gets executed by the %s", jdbcTemplate)
                .yellow("which prepares the statement before hand")
                .green("We do define how to prepare it, but preparation means optimizing the query before execution")
                .yellow("and Spring does that for us by means of a PreparedStatement")
                .green("We access the PreparedStatement via the callback %s", preparedStatementCallback)
                .yellow("And this is the result %s", execute);
    }
}
