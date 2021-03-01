package org.jesperancinha.std.flash216.platformtransactionmanagement.service;

import org.jesperancinha.std.flash216.platformtransactionmanagement.domain.Award;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.time.LocalDateTime;
import java.util.List;

@Component
public class AwardDaoImpl implements AwardDao {
    private JdbcTemplate jdbcTemplate ;
    private PlatformTransactionManager transactionManager;

    public AwardDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.transactionManager = transactionManager;
        this.jdbcTemplate = new JdbcTemplate(dataSource);
    }

    @Override
    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE AWARDS(\n" +
                "   ID   INT NOT NULL AUTO_INCREMENT,\n" +
                "   ARTIST VARCHAR(255) NOT NULL,\n" +
                "   AWARD VARCHAR(255) NOT NULL,\n" +
                "   AWARD_DATE TIMESTAMP NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");");
    }

    @Override
    public Award create(String artist, String award, LocalDateTime awardDateTime) {
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            jdbcTemplate.update("insert into AWARDS (ARTIST, AWARD, AWARD_DATE) values (?, ?, ?)", artist, award, awardDateTime);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        final Award award1 = new Award();
        award1.setAward(award);
        award1.setArtist(artist);
        award1.setAwardDate(awardDateTime);
        return award1;
    }

    @Override
    public List<Award> listAwards() {
        return jdbcTemplate.query("select * from awards",
                (rs, rowNum) -> {
                    final Award award = new Award();
                    award.setArtist(rs.getString("ARTIST"));
                    award.setAward(rs.getString("AWARD"));
                    award.setAwardDate(rs.getTimestamp("AWARD_DATE").toLocalDateTime());
                    return award;
                });
    }
}
