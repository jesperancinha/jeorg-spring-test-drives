package org.jesperancinha.std.flash217.jtatransactionmanagement.service;

import org.jesperancinha.std.flash217.jtatransactionmanagement.domain.Marble;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Service
public class MarbleDaoImpl implements MarbleDao {

    private final JdbcTemplate jdbcTemplate;
    private final PlatformTransactionManager transactionManager;

    public MarbleDaoImpl(DataSource dataSource, PlatformTransactionManager transactionManager) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.transactionManager = transactionManager;
    }

    @Override
    public void createTables() {
        jdbcTemplate.execute("CREATE TABLE MARBLES(\n" +
                "   ID INT NOT NULL AUTO_INCREMENT,\n" +
                "   NAME VARCHAR(255) NOT NULL,\n" +
                "   COLOR VARCHAR(255) NOT NULL,\n" +
                "   PRIMARY KEY (ID)\n" +
                ");");
    }

    @Override
    public Marble create(String name, String color) {
        TransactionDefinition defaultTransactionDefinition = new DefaultTransactionDefinition();
        TransactionStatus status = transactionManager.getTransaction(defaultTransactionDefinition);
        try {
            jdbcTemplate.update("insert into MARBLES (NAME, COLOR) values (?, ?)", name, color);
            transactionManager.commit(status);
        } catch (DataAccessException e) {
            System.out.println("Error in creating record, rolling back");
            transactionManager.rollback(status);
            throw e;
        }
        final Marble marble = new Marble();
        marble.setColor(color);
        marble.setName(name);
        return marble;
    }

    public List<Marble> listMarbles() {
        return this.jdbcTemplate.query("select * from MARBLES", new RowMapper<Marble>() {
            @Override
            public Marble mapRow(ResultSet rs, int rowNum) throws SQLException {
                final Marble marble = new Marble();
                marble.setName(rs.getString("name"));
                marble.setColor(rs.getString("color"));
                return marble;
            }
        });
    }
}
