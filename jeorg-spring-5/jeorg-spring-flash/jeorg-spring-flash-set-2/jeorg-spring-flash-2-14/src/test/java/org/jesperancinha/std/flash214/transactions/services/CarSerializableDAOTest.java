package org.jesperancinha.std.flash214.transactions.services;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.testcontainers.containers.PostgreSQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static java.lang.Thread.sleep;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("emb")
@ComponentScan({
        "org.jesperancinha.std.flash214.transactions",
        "org.jesperancinha.std.flash214.transactions.services"
})
@Sql(executionPhase = BEFORE_TEST_METHOD,
        scripts = "classpath:schema.sql")
@Testcontainers
class CarSerializableDAOTest {

    @Autowired
    private CarSerializableDAO carSerializableDAO;

    @Container
    private static PostgreSQLContainer postgreSQLContainer = new PostgreSQLContainer()
            .withDatabaseName("db")
            .withUsername("sa")
            .withPassword("sa");

    @BeforeEach
    public void setup() {
        assertThat(postgreSQLContainer.isRunning()).isTrue();
    }

    /**
     * A running example for the serializable isolation level
     *
     * @throws InterruptedException An error
     */
    @Test
    void testSerializableWhenRunningThenExemplifySerializable() throws InterruptedException {
        ConsolerizerComposer.outSpace()
                .cyan(title("Serializable"))
                .magenta("In this example, we are writing data in one transaction.")
                .magenta("At the same time, another transaction is starting.")
                .magenta("Serializable transactions only allow reading after on transaction is done. Transaction gain a locked access to the database.")
                .magenta("This way, it is not possible to keep up with the progress in the database via one reading transaction with Serializable isolation level.")
                .magenta("In this Serializable example, we'll see that transactions block each other until completion.")
                .magenta("There is no possibility of phantom reads, because transactions get exclusive access. There are different kinds of locks. This is only the basic way of using locks.")
                .reset();
        final var executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            try {
                sleep(500);
            } catch (InterruptedException e) {
                RED.printThrowableAndExit(e);
            }
            carSerializableDAO.createCar(Car.builder().brand("Citroën").model("2CV").build());
        });
        executorService.submit(() -> {
            carSerializableDAO.getAllCars();
            carSerializableDAO.getAllCars();
        });
        executorService.shutdown();
        final boolean termination = executorService.awaitTermination(50, TimeUnit.SECONDS);
        assertThat(termination).isTrue();
    }
}