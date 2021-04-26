package org.jesperancinha.std.flash214.transactions;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.jesperancinha.std.flash214.transactions.repository.CarRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import javax.sql.DataSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.context.jdbc.Sql.ExecutionPhase.BEFORE_TEST_METHOD;

@SpringBootTest
@ActiveProfiles("emb")
@ComponentScan("org.jesperancinha.std.flash214.transactions")
@Sql(executionPhase = BEFORE_TEST_METHOD,
        scripts = "classpath:schema.sql")
class SpringFlash214LauncherTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private CarRepository carRepository;

    @Test
    void testContext() {
        ConsolerizerComposer.outSpace()
                .magenta("This is our working database configuration")
                .magenta(((DriverManagerDataSource) dataSource).getUrl())
                .magenta(((DriverManagerDataSource) dataSource).getUsername())
                .magenta(((DriverManagerDataSource) dataSource).getPassword())
                .reset();

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