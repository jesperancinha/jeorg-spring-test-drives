package org.jesperancinha.std.flash217.jtatransactionmanagement.service;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash217.jtatransactionmanagement.domain.Marble;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@Service
public class MarbleDaoImpl implements MarbleDao {

    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

    /**
     * @param dataSource         {@link DataSource} The currently configured datasource
     * @param transactionManager {@link PlatformTransactionManager} The currently configured platform transaction manager
     */
    public MarbleDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.transactionManager = transactionManager;
    }

    /**
     * Creates the tables needed for this module
     */
    @Override
    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE MARBLES(\n" +
                "   ID INT NOT NULL AUTO_INCREMENT,\n" +
                "   NAME VARCHAR(255) NOT NULL,\n" +
                "   COLOR VARCHAR(255) NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");");
    }

    /**
     * Removes all data from the table {@link Marble}, to allow a fresh start for the following test
     */
    @Override
    public void resetDatabase() {
        jdbcTemplate.execute("delete from MARBLES;");
    }

    /**
     * Creates a marble record in a typical fashion.
     * The {@link PlatformTransactionManager} allows for commits and rollbacks when needed.
     *
     * @param name  Marble name {@link String}
     * @param color Marble color {@link String}
     * @return One {@link Marble}
     */
    @Override
    public Marble create(String name, String color) {
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into MARBLES (NAME, COLOR) values (?, ?)", name, color);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return getMarble();
    }

    /**
     * Tries to create a marble record but it will purpously fail in order to demonstrat the rollback mechanism
     *
     * @param name  Marble name {@link String}
     * @param color Marble color {@link String}
     * @return One {@link Marble}
     */
    @Override
    public Marble createRollback(String name, String color) {
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into MARBLES (NAME, COLOR) values (?, ?)", name, color);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.rollback(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return getMarble();
    }

    /**
     * Creates an marble record in a failed fashion
     * The rollback will be purpously performed after the commit as been issued.
     * After the commit, it is evidently not possible to rollback.
     * The exception is cached and this returns the marble anyways.
     *
     * @param name  Marble name {@link String}
     * @param color Marble color {@link String}
     * @return One {@link Marble}
     */
    @Override
    public Marble createFailRollback(String name, String color) {
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into MARBLES (NAME, COLOR) values (?, ?)", name, color);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.commit(status);
            transactionManager.rollback(status);
        } catch (final IllegalTransactionStateException exception) {
            ConsolerizerComposer.outSpace()
                    .red(title("Expected Exception"))
                    .red(exception);
        }
        return getMarble();
    }

    @Override
    public Marble createNoTransaction(String name, String color) {
        final int update = jdbcTemplate.update("insert into MARBLES (NAME, COLOR) values (?, ?)", name, color);
        ConsolerizerComposer.outSpace()
                .green("Updated %d record(s)", update);

        return getMarble();
    }

    /**
     * Returns the current list of marbles in the database
     *
     * @return {@link List<Marble>} List of marbles in the database
     */
    public List<Marble> listMarbles() {
        return this.jdbcTemplate.query("select * from MARBLES", new RowMapper<Marble>() {
            @Override
            public Marble mapRow(ResultSet rs, int rowNum) throws SQLException {
                return createMarble(rs);
            }
        });
    }

    /**
     * Gets the first found marble record on the table.
     *
     * @return The resulting {@link Marble}. In case of an empty result, it returns null.
     */
    @Nullable
    private Marble getMarble() {
        final var query = jdbcTemplate.query("select * from MARBLES",
                (rs, i) -> createMarble(rs));
        if (query.size() == 0) {
            return null;
        }
        return query.get(0);
    }

    private Marble createMarble(ResultSet rs) throws SQLException {
        return Marble
                .builder()
                .name(rs.getString("name"))
                .color(rs.getString("color"))
                .build();
    }
}
