package org.jesperancinha.std.mastery3.plants.dao;

import org.jesperancinha.std.mastery3.plants.configuration.JmpConfigBean;
import org.jesperancinha.std.mastery3.plants.model.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@MockBean({JmpConfigBean.class, PlantDao.class})
public class PlantDaoTest {

    @Autowired
    private PlantDao plantDao;

    @Test
    public void testCreatePlantWhenTryingToCreateThenReturnNull() {
        final var plant = plantDao.createPlant(
                Plant.builder()
                        .name("Yucca")
                        .scientificName("Yucca filamentosa")
                        .build());

        assertThat(plant).isNull();
    }
}