package com.steelzack.b2b2java8.comparing;

import java.util.Comparator;
import java.util.Date;

/**
 * Created by jesperancinha on 10-5-16.
 */
public class PlantComparators {

    private static Comparator<String> compareToString = String::compareTo;
    private static Comparator<Integer> compareToInteger = Integer::compareTo;
    private static Comparator<Date> compareToDate = Date::compareTo;

    public static Comparator<Plant> getComparatorScientificName() {
        return Comparator.comparing(Plant::getScientificName, Comparator.nullsFirst(compareToString));
    }

    public static Comparator<Plant> getComparatorPlantingDate() {
        return Comparator.comparing(Plant::getPlantingDate, Comparator.nullsFirst(compareToDate));
    }

    public static Comparator<Plant> getComparatorHeight() {
        return Comparator.comparing(Plant::getHeight, Comparator.nullsFirst(compareToInteger));
    }
}
