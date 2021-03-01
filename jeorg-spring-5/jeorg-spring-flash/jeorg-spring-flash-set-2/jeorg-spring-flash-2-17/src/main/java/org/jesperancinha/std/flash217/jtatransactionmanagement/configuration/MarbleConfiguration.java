package org.jesperancinha.std.flash217.jtatransactionmanagement.configuration;

import com.atomikos.icatch.jta.UserTransactionImp;
import com.atomikos.icatch.jta.UserTransactionManager;
import com.atomikos.jdbc.AtomikosNonXADataSourceBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.jta.JtaTransactionManager;

import javax.sql.DataSource;
import javax.transaction.SystemException;
import javax.transaction.TransactionManager;
import javax.transaction.UserTransaction;
import java.util.UUID;

@EnableTransactionManagement
@Configuration
public class MarbleConfiguration {

    private static final int MAX_CONNECTIONS_PER_DATABASE = 10;
    private static final int TRANSACTION_TIMEOUT = 5;

    @Value("${spring.datasource.url}")
    public String url;

    @Value("${spring.datasource.username}")
    public String user;

    @Value("${spring.datasource.password}")
    public String password;

    @Value("${spring.datasource.driverClassName}")
    public String driver;

    @Bean
    public DataSource dataSource() {
        AtomikosNonXADataSourceBean ds = new AtomikosNonXADataSourceBean();
        ds.setDriverClassName(driver);
        ds.setUrl(url);
        ds.setUser(user);
        ds.setPassword(password);
        ds.setUniqueResourceName(UUID.randomUUID().toString());
        ds.setLocalTransactionMode(true);
        ds.setMaxPoolSize(MAX_CONNECTIONS_PER_DATABASE);
        return ds;
    }

    @Bean(destroyMethod = "close",
            initMethod = "init")
    public TransactionManager atomikosTransactionManager() throws SystemException {
        UserTransactionManager userTransactionManager = new UserTransactionManager();
        userTransactionManager.setForceShutdown(false);
        userTransactionManager.setTransactionTimeout(TRANSACTION_TIMEOUT);
        return userTransactionManager;
    }


    @Bean
    public UserTransaction userTransaction() throws SystemException {
        UserTransactionImp userTransaction = new UserTransactionImp();
        userTransaction.setTransactionTimeout(TRANSACTION_TIMEOUT);
        return userTransaction;
    }

    @Bean(name = "transactionManager")
    public PlatformTransactionManager transactionManager(UserTransaction userTransaction, TransactionManager atomikosTransactionManager) throws Throwable {
        JtaTransactionManager jtaTransactionManager = new JtaTransactionManager(userTransaction, atomikosTransactionManager);
        jtaTransactionManager.setDefaultTimeout(TRANSACTION_TIMEOUT);
        return jtaTransactionManager;
    }
}