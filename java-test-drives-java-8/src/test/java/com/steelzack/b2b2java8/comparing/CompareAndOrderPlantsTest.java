package com.steelzack.b2b2java8.comparing;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * Created by jesperancinha on 10-5-16.
 */
public class CompareAndOrderPlantsTest {
    @Test
    public void sort() throws Exception {

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

        assertThat(plant1.getScientificName(), equalTo("Acer glabrum"));
        assertThat(plant2.getScientificName(), equalTo("Acer glabrum"));
        assertThat(plant3.getScientificName(), equalTo("Eriogonum ovalifolium"));
        assertThat(plant4.getScientificName(), equalTo("Eriogonum ovalifolium"));
        assertThat(plant5.getScientificName(), equalTo("Eriogonum strictum"));
        assertThat(plant6.getScientificName(), equalTo("Eriogonum strictum"));

        assertThat(plant1.getHeight(), equalTo(2));
        assertThat(plant2.getHeight(), equalTo(10));
        assertThat(plant3.getHeight(), equalTo(1));
        assertThat(plant4.getHeight(), equalTo(4));
        assertThat(plant5.getHeight(), equalTo(23));
        assertThat(plant6.getHeight(), equalTo(45));

    }

}
