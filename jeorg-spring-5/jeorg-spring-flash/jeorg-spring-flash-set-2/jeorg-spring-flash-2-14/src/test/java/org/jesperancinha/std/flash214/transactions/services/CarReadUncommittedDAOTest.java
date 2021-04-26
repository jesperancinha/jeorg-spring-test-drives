package org.jesperancinha.std.flash214.transactions.services;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;

@SpringBootTest
@ActiveProfiles("emb")
@ComponentScan({"org.jesperancinha.std.flash214.transactions", "org.jesperancinha.std.flash214.transactions.services"})
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "classpath:schema.sql")
class CarReadUncommittedDAOTest {

    @Autowired
    private CarReadUncommittedDAO carReadUncommittedDAO;


    @Test
    void testReadUncommitted_whenRunning_thenExemplifyReadUncommitted() throws InterruptedException {
        ConsolerizerComposer.outSpace()
                .cyan(title("Read Uncommitted"))
                .magenta("In this example, we are writing data in one transaction.")
                .magenta("At the same time, another transaction is starting.")
                .magenta("Our embedded database, and many database systems do not support read uncommitted.")
                .magenta("This is the reason why this example works in the same way as the read committed one.")
                .magenta("In a read uncommitted example, we would see that we would be able to read the progress of one transaction from another read uncommitted transaction.")
                .reset();
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(() -> {
            carReadUncommittedDAO.createCar(Car.builder().brand("Citroën").model("2CV").build());
        });
        executorService.submit(() -> {
            carReadUncommittedDAO.getAllCars();
            carReadUncommittedDAO.getAllCars();
            carReadUncommittedDAO.getAllCars();
            carReadUncommittedDAO.getAllCars();
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