package org.jesperancinha.std.app1.jdbc.containers

import org.springframework.context.ApplicationContextInitializer
import org.springframework.context.ConfigurableApplicationContext
import org.springframework.test.context.support.TestPropertySourceUtils
import org.testcontainers.containers.PostgreSQLContainer

object AbstractTestContainersKotlinIT {
    val postgreSQLContainer: PostgreSQLContainer<*> by lazy {
        PostgreSQLContainer("postgres:14")
            .withUsername("postgres")
            .withPassword("password")
            .withDatabaseName("cruises")
            .withReuse(true)
            .also { it.start() }
    }

    class DockerPostgresDataInitializer : ApplicationContextInitializer<ConfigurableApplicationContext> {
        private var jdbcUrl = "spring.datasource.url=" + postgreSQLContainer.jdbcUrl
        private var username = "spring.datasource.username=" + postgreSQLContainer.username
        private var password = "spring.datasource.password=" + postgreSQLContainer.password
        override fun initialize(applicationContext: ConfigurableApplicationContext) {
            TestPropertySourceUtils
                .addInlinedPropertiesToEnvironment(applicationContext, jdbcUrl, username, password)
        }
    }
}