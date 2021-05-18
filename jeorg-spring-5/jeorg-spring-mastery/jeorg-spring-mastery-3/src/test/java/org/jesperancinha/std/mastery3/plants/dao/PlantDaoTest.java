package org.jesperancinha.std.mastery3.plants.dao;

import org.jesperancinha.std.mastery3.plants.model.Plant;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
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