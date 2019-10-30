package com.steelzack.b2b2java8.collections;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Collections1 {

    private List<String> testArrayOfStrings;

    public Collections1(List<String> testArrayOfStrings) {
        this.testArrayOfStrings = testArrayOfStrings;
    }

    protected List<String> getStringsThatStartWith(String filter) {
        Stream<String> stream = testArrayOfStrings.stream();
        return stream.filter(item -> item.startsWith(filter)).collect(Collectors.toList());
    }

    protected List<String> getStringsThatContain(String filter) {
        Stream<String> stream = testArrayOfStrings.stream();
        return stream.filter(item -> item.contains(filter)).collect(Collectors.toList());
    }

    protected List<String> mapToUppercaseOnlyFiletr(String filter) {
        Stream<String> stream = testArrayOfStrings.stream();
        return stream.map(item -> item.replace(filter, filter.toUpperCase())).collect(Collectors.toList());
    }
}
