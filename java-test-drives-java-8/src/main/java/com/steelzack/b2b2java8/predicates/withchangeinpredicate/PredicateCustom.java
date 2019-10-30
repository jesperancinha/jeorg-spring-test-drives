package com.steelzack.b2b2java8.predicates.withchangeinpredicate;

import com.steelzack.b2b2java8.predicates.Something;
import lombok.Builder;

import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * Created by joao on 14-5-16.
 */
@Builder
public class PredicateCustom implements Predicate<Something> {

    private Set<String> doneWith;
    private Set<String> recipients;

    @Override
    public boolean test(Something record) {
        boolean notify = Stream.of(doneWith, recipients)
                .noneMatch(s -> s.contains(record.getName()));

        if (notify) {
            doneWith.add(record.getName());
        }
        return notify;
    }
}
