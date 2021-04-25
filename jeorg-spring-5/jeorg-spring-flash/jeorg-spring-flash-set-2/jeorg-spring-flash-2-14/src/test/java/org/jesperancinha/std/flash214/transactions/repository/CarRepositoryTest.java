package org.jesperancinha.std.flash214.transactions.repository;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash214.transactions.model.Car;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@ActiveProfiles("emb")
@ComponentScan("org.jesperancinha.std.flash214.transactions")
@Sql(executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD,
        scripts = "classpath:schema.sql")
class CarRepositoryTest {

    @Autowired
    private CarRepository carRepository;

    @Test
    public void testSave_whenSaveCar_thenRetrieveIt() {
        final var car = Car.builder().brand("Renault").model("Twingo").build();

        final Car savedCar = carRepository.save(car);

        ConsolerizerComposer.outSpace()
                .green("This car has just been saved in the database:")
                .jsonPrettyPrint(car)
                .reset();

        assertThat(savedCar).isNotNull();
        assertThat(savedCar.getBrand()).isEqualTo("Renault");
        assertThat(savedCar.getModel()).isEqualTo("Twingo");
    }

}