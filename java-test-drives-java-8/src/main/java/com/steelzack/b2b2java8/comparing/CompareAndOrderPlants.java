package com.steelzack.b2b2java8.comparing;

import java.util.List;

public class CompareAndOrderPlants {

    public void sort(List<Plant> list, Criteria criteria1, Criteria criteria2) {

        list.sort(Criteria.SCIENTIFICNAME.getComparator().thenComparing(criteria1.getComparator().thenComparing(criteria2.getComparator())));

    }
}
