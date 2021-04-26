package org.jesperancinha.std.flash216.platformtransactionmanagement.service;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash216.platformtransactionmanagement.domain.Award;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.transaction.IllegalTransactionStateException;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@Component
public class AwardDaoImpl implements AwardDao {
    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

    public AwardDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE AWARDS(\n" +
                "   ID INT NOT NULL AUTO_INCREMENT,\n" +
                "   ARTIST VARCHAR(255) NOT NULL,\n" +
                "   AWARD VARCHAR(255) NOT NULL,\n" +
                "   AWARD_DATE TIMESTAMP NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");");
    }

    @Override
    public void resetDatabase() {
        jdbcTemplate.execute("delete from awards;");
    }

    @Override
    public Award create(String artist, String award, LocalDateTime awardDateTime) {
        final var defaultTransactionDefinition = new DefaultTransactionDefinition();
        final var status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into AWARDS (ARTIST, AWARD, AWARD_DATE) values (?, ?, ?)", artist, award, awardDateTime);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return getAward();
    }

    @Override
    public Award createRollback(String artist, String award, LocalDateTime awardDateTime) {
        final var defaultTransactionDefinition = new DefaultTransactionDefinition();
        final var status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into AWARDS (ARTIST, AWARD, AWARD_DATE) values (?, ?, ?)", artist, award, awardDateTime);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.rollback(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        return getAward();
    }

    @Override
    public Award createFailRollback(String artist, String award, LocalDateTime awardDateTime) {
        final var defaultTransactionDefinition = new DefaultTransactionDefinition();
        final var status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            final int update = jdbcTemplate.update("insert into AWARDS (ARTIST, AWARD, AWARD_DATE) values (?, ?, ?)", artist, award, awardDateTime);
            ConsolerizerComposer.outSpace()
                    .green("Updated %d record(s)", update);
            transactionManager.commit(status);
            transactionManager.rollback(status);
        } catch (final IllegalTransactionStateException exception) {
            ConsolerizerComposer.outSpace()
                    .red(title("Expected Exception"))
                    .red(exception);
        }
        return getAward();
    }

    @Override
    public Award createNoTransaction(String artist, String award, LocalDateTime awardDateTime) {
        final int update = jdbcTemplate.update("insert into AWARDS (ARTIST, AWARD, AWARD_DATE) values (?, ?, ?)", artist, award, awardDateTime);
        ConsolerizerComposer.outSpace()
                .green("Updated %d record(s)", update);

        return getAward();
    }

    @Override
    public List<Award> listAwards() {
        return jdbcTemplate.query("select * from awards",
                (rs, rowNum) -> Award
                        .builder()
                        .artist(rs.getString("ARTIST"))
                        .award(rs.getString("AWARD"))
                        .awardDate(rs.getTimestamp("AWARD_DATE").toLocalDateTime())
                        .build());
    }

    @Nullable
    private Award getAward() {
        final var query = jdbcTemplate.query("select * from AWARDS", (rs, i) -> Award
                .builder()
                .artist(rs.getString("ARTIST"))
                .award(rs.getString("AWARD"))
                .awardDate(rs.getTimestamp("AWARD_DATE").toLocalDateTime())
                .build());
        if (query.size() == 0) {
            return null;
        }
        return query.get(0);
    }
}
