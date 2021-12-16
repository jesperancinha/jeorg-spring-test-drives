package org.jesperancinha.std.flash214.transactions;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.util.TestPropertyValues;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("emb")
@ComponentScan("org.jesperancinha.std.flash214.transactions")
@Sql(executionPhase = BEFORE_TEST_METHOD,
        scripts = "classpath:schema.sql")
@Testcontainers
@ContextConfiguration(initializers = {SpringFlash214LauncherTest.Initializer.class})
class SpringFlash214LauncherTest {

    @Autowired
    private CarRepository carRepository;

    @Container
    static PostgreSQLContainer<?> postgreSQLContainer = new PostgreSQLContainer<>("postgres:12")
            .withUsername("postgres")
            .withPassword("admin")
            .withDatabaseName("db");

    static class Initializer
            implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
            TestPropertyValues.of(
                    "spring.datasource.url=" + postgreSQLContainer.getJdbcUrl(),
                    "spring.datasource.username=" + postgreSQLContainer.getUsername(),
                    "spring.datasource.password=" + postgreSQLContainer.getPassword()
            ).applyTo(configurableApplicationContext.getEnvironment());
        }
    }
    @BeforeEach
    public void setup() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }

    @Test
    void testContext() {
        final var car = Car.builder().brand("Renault").model("Twingo").build();

        final var savedCar = carRepository.save(car);

        ConsolerizerComposer.outSpace()
                .green("This car has just been saved in the database:")
                .jsonPrettyPrint(car)
                .reset();

        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getBrand()).isEqualTo("Renault");
        assertThat(savedCar.getModel()).isEqualTo("Twingo");
    }
}