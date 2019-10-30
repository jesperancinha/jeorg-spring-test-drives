package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import com.steelzack.b2b2java8.predicates.Something;
import lombok.Builder;

import java.util.Set;
import java.util.function.Predicate;

/**
 * Created by joao on 14-5-16.
 */
@Builder
public class PredicateCustom implements Predicate<Something> {
    private Set<String> listToFind;

    @Override
    public boolean test(Something record) {
        return listToFind.parallelStream()
                .noneMatch(s -> s.contains(record.getName()));
    }

}
