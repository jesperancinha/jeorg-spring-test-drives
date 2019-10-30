package com.steelzack.b2b2java8.comparing;

import static com.steelzack.b2b2java8.comparing.PlantComparators.getComparatorHeight;
import static com.steelzack.b2b2java8.comparing.PlantComparators.getComparatorPlantingDate;
import static com.steelzack.b2b2java8.comparing.PlantComparators.getComparatorScientificName;

import java.util.Comparator;
import java.util.List;

import lombok.Getter;

/**
 * Created by jesperancinha on 10-5-16.
 */

@Getter
public enum Criteria {
    SCIENTIFICNAME(getComparatorScientificName()),
    HEIGHT(getComparatorHeight()),
    PLANTINGDATE(getComparatorPlantingDate());

    private final  Comparator<Plant> comparator;

    Criteria(Comparator<Plant> comparator) {

        this.comparator = comparator;
    }

    public void sort(List<Plant> plantList){
       plantList.sort(comparator);
    }


}
