package org.jesperancinha.std.flash214.transactions.configuration;

import de.flapdoodle.embed.process.runtime.Network;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import ru.yandex.qatools.embed.postgresql.PostgresExecutable;
import ru.yandex.qatools.embed.postgresql.PostgresProcess;
import ru.yandex.qatools.embed.postgresql.PostgresStarter;
import ru.yandex.qatools.embed.postgresql.config.AbstractPostgresConfig;
import ru.yandex.qatools.embed.postgresql.config.PostgresConfig;
import ru.yandex.qatools.embed.postgresql.distribution.Version;

import javax.sql.DataSource;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Properties;

import static java.lang.String.format;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@Configuration
public class DbConfig {

    private static final List<String> DEFAULT_ADDITIONAL_INIT_DB_PARAMS =
            Collections.singletonList("--nosync");

    @Bean
    public PostgresConfig postgresConfig() throws IOException {
        final PostgresConfig postgresConfig = new PostgresConfig(Version.V10_6,
                new AbstractPostgresConfig.Net("localhost", Network.getFreeServerPort()),
                new AbstractPostgresConfig.Storage("db"),
                new AbstractPostgresConfig.Timeout(),
                new AbstractPostgresConfig.Credentials("sa", "sa")
        );
        postgresConfig.getAdditionalInitDbParams().addAll(DEFAULT_ADDITIONAL_INIT_DB_PARAMS);

        return postgresConfig;
    }

    @Bean
    @DependsOn("postgresProcess")
    public DataSource dataSource(PostgresConfig config) {

        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.postgresql.Driver");
        ds.setUrl(format("jdbc:postgresql://%s:%s/%s", config.net().host(), config.net().port(), config.storage().dbName()));
        ds.setUsername(config.credentials().username());
        ds.setPassword(config.credentials().password());
        ds.setConnectionProperties(properties());
        return ds;
    }

    private Properties properties() {
        Properties properties = new Properties();
        properties.put("hibernate.show_sql", "true");
        properties.put("hibernate.format_sql", "true");
        return properties;
    }

    @Bean(destroyMethod = "stop")
    public PostgresProcess postgresProcess(PostgresConfig config) throws IOException {
        PostgresStarter<PostgresExecutable, PostgresProcess> runtime = PostgresStarter.getDefaultInstance();
        PostgresExecutable exec = runtime.prepare(config);
        try {
            return exec.start();
        } catch (final FileNotFoundException fileNotFoundException) {
            ConsolerizerComposer.outSpace()
                    .orange("Warning, nos postgres process has started!")
                    .orange(fileNotFoundException)
                    .reset();
            RED.printExpectedException("Postgres not able to start!", fileNotFoundException);
            throw fileNotFoundException;
        }
    }
}
