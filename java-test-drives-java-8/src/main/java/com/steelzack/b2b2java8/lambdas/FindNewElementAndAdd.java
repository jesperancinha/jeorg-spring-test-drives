package com.steelzack.b2b2java8.lambdas;

import lombok.Builder;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

/**
 * Created by joao on 15-5-16.
 */
@Builder
public class FindNewElementAndAdd {

    List<String[]> rowList;

public String[] generateFirstRow(int startingRow) {

    final String[] row1 = rowList.get(startingRow);
    final String[] row2 = rowList.get(startingRow + 1);
    final List<String> list1 = Arrays.stream(row1).collect(toList());
    final List<String> toAdd = Arrays.stream(row2).parallel().sorted().filter(s -> !list1.contains(s)).collect(Collectors.toList());
    list1.addAll(toAdd);
    return list1.toArray(new String[0]);

}
}
