package com.steelzack.b2b2bwebapp.config;

import com.steelzack.b2b2bwebapp.service.DetailController;
import com.steelzack.b2b2bwebapp.service.DetailService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.concurrent.ConcurrentMapCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.SimpleDriverDataSource;
import org.springframework.jdbc.datasource.init.DatabasePopulator;
import org.springframework.jdbc.datasource.init.DatabasePopulatorUtils;
import org.springframework.jdbc.datasource.init.ResourceDatabasePopulator;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.Properties;

/**
 * Created by joao on 15-5-16.
 */

@Configuration
@EnableJpaRepositories(basePackages = "com.steelzack.b2b2bwebapp")
@EnableTransactionManagement
@EnableCaching
@PropertySource({"classpath:config.properties", "classpath:db.properties"})
@ComponentScan
public class DetailConfig {

    @Bean
    CacheManager cacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        cacheManager.setCaches(Arrays.asList(new ConcurrentMapCache("detailCache")));
        return cacheManager;
    }


    @Bean
    public DetailService detailService() {
        return new DetailService();
    }

    @Bean
    public DetailController detailController() {
        return new DetailController();
    }

    @Bean
    public DataSource dataSource() {
        DataSource dataSource = createDataSource("");
        DatabasePopulatorUtils.execute(createDatabasePopulator("create.sql"), dataSource);
        dataSource = createDataSource("/test");
        DatabasePopulatorUtils.execute(createDatabasePopulator("schema.sql"), dataSource);
        return dataSource;
    }


    private DatabasePopulator createDatabasePopulator(String script) {
        ResourceDatabasePopulator databasePopulator = new ResourceDatabasePopulator();
        databasePopulator.setContinueOnError(true);
        databasePopulator.addScript(new ClassPathResource(script));
        return databasePopulator;
    }

    private SimpleDriverDataSource createDataSource(String database) {
        SimpleDriverDataSource simpleDriverDataSource = new SimpleDriverDataSource();
        simpleDriverDataSource.setDriverClass(org.postgresql.Driver.class);
        simpleDriverDataSource.setUrl("jdbc:postgresql://localhost" + database);
        simpleDriverDataSource.setUsername("postgres");
        simpleDriverDataSource.setPassword("postgres");
        return simpleDriverDataSource;
    }

    @Value("${hibernate.cache.use_second_level_cache:true}")
    private String useSecondLevelCache;


    @Bean
    public EntityManagerFactory entityManagerFactory() {
        HibernateJpaVendorAdapter vendorAdapter = new HibernateJpaVendorAdapter();
        vendorAdapter.setGenerateDdl(true);
        LocalContainerEntityManagerFactoryBean factory = new LocalContainerEntityManagerFactoryBean();
        factory.setJpaVendorAdapter(vendorAdapter);
        factory.setPackagesToScan("com.steelzack.b2b2bwebapp.model");
        factory.setDataSource(dataSource());
        final Properties connectionProperties = new Properties();
        connectionProperties.setProperty("hibernate.connection.autocommit", "true");
        connectionProperties.setProperty("hibernate.hbm2ddl.auto", "create");
        connectionProperties.setProperty("hibernate.cache.provider_class", "org.hibernate.cache.EhCacheProvider");
        connectionProperties.setProperty("hibernate.cache.use_structured_entries", "true");
        connectionProperties.setProperty("hibernate.cache.region.factory_class", "org.hibernate.cache.ehcache.EhCacheRegionFactory");
        connectionProperties.setProperty("hibernate.cache.use_second_level_cache", this.useSecondLevelCache);
        factory.setJpaProperties(connectionProperties);
        factory.afterPropertiesSet();
        return factory.getObject();
    }

    @Bean
    public PlatformTransactionManager transactionManager() {
        JpaTransactionManager txManager = new JpaTransactionManager();
        txManager.setEntityManagerFactory(entityManagerFactory());
        return txManager;
    }

    @Bean
    public static PropertySourcesPlaceholderConfigurer placeholderConfigurer() {
        return new PropertySourcesPlaceholderConfigurer();
    }

}
