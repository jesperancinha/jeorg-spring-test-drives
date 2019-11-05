package org.jesperancinha.b2b2java8.comparing;


import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CompareAndOrderPlantsTest {

    @Test
    public void sort() {

        List<Plant> plantList = Arrays.asList(
                Plant.builder().scientificName("Acer glabrum").height(10).build(),
                Plant.builder().scientificName("Acer glabrum").height(2).build(),
                Plant.builder().scientificName("Eriogonum strictum").height(45).build(),
                Plant.builder().scientificName("Eriogonum strictum").height(23).build(),
                Plant.builder().scientificName("Eriogonum ovalifolium").height(4).build(),
                Plant.builder().scientificName("Eriogonum ovalifolium").height(1).build()
        );

        final CompareAndOrderPlants compareAndOrderPlantsTest = new CompareAndOrderPlants();

        compareAndOrderPlantsTest.sort(plantList, Criteria.HEIGHT, Criteria.PLANTINGDATE);

        final Plant plant1 = plantList.get(0);
        final Plant plant2 = plantList.get(1);
        final Plant plant3 = plantList.get(2);
        final Plant plant4 = plantList.get(3);
        final Plant plant5 = plantList.get(4);
        final Plant plant6 = plantList.get(5);

        assertThat(plant1.getScientificName()).isEqualTo("Acer glabrum");
        assertThat(plant2.getScientificName()).isEqualTo("Acer glabrum");
        assertThat(plant3.getScientificName()).isEqualTo("Eriogonum ovalifolium");
        assertThat(plant4.getScientificName()).isEqualTo("Eriogonum ovalifolium");
        assertThat(plant5.getScientificName()).isEqualTo("Eriogonum strictum");
        assertThat(plant6.getScientificName()).isEqualTo("Eriogonum strictum");

        assertThat(plant1.getHeight()).isEqualTo(2);
        assertThat(plant2.getHeight()).isEqualTo(10);
        assertThat(plant3.getHeight()).isEqualTo(1);
        assertThat(plant4.getHeight()).isEqualTo(4);
        assertThat(plant5.getHeight()).isEqualTo(23);
        assertThat(plant6.getHeight()).isEqualTo(45);

    }

}
