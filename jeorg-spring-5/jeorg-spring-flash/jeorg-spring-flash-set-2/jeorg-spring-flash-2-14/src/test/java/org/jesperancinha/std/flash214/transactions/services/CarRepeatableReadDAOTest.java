package org.jesperancinha.std.flash214.transactions.services;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

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
class CarRepeatableReadDAOTest {

    @Autowired
    private CarRepeatableReadDAO carRepeatableReadDAO;

    /**
     * A running example for the repeatable read isolation level
     *
     * @throws InterruptedException An error
     */
    @Test
    void testRepeatableRead_whenRunning_thenExemplifyRepeatableRead() throws InterruptedException {
        ConsolerizerComposer.outSpace()
                .cyan(title("Repeatable Read"))
                .magenta("In this example, we are writing data in one transaction.")
                .magenta("At the same time, another transaction is starting.")
                .magenta("A Repeatable read means that the reader transaction will always read at least the same.")
                .magenta("The small nuance comes from the fact that removals will not be detected. Additions, however will.")
                .magenta("In this repeatable read example, we will see how we can read the progress of one transaction from another repeatable transaction.")
                .magenta("We won't, in any case, see the removals, nor we will see the aditions. This is after all, an embedded database system")
                .reset();
        final var executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            final var car = carRepeatableReadDAO.createCar(Car.builder().brand("Citroën").model("2CV").build());
            carRepeatableReadDAO.createCar(Car.builder().brand("Citroën").model("2CV").build());
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                RED.printThrowableAndExit(e);
            }
            carRepeatableReadDAO.deleteCarById(car.getId());
        });
        executorService.submit(() -> {
            ConsolerizerComposer.outSpace().yellow("First repeatable read transaction. Phantom reads would occur here in a supportive real database");
            carRepeatableReadDAO.getAllCars();
            ConsolerizerComposer.outSpace().yellow("Second repeatable read transaction. Phantom reads would occur here in a supportive real database");
            carRepeatableReadDAO.getAllCars();
            ConsolerizerComposer.outSpace().yellow("Third repeatable read transaction. Phantom reads would occur here in a supportive real database");
            carRepeatableReadDAO.getAllCars();
        });
        executorService.shutdown();
        final boolean termination = executorService.awaitTermination(10, TimeUnit.SECONDS);
        assertThat(termination).isTrue();
    }


    @Test
    void createCar() {
    }

    @Test
    void getCarById() {
    }

    @Test
    void getAllCars() {
    }

    @Test
    void deleteCarById() {
    }

}