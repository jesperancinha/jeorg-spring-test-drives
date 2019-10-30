package org.jesperancinha.b2b2java8.predicates.withchangeinpredicate;

import org.jesperancinha.b2b2java8.predicates.SomeServiceInterface;
import org.jesperancinha.b2b2java8.predicates.Something;

import java.util.function.Predicate;

/**
 * Created by joao on 13-5-16.
 */
public class SomethingService implements SomeServiceInterface {

    @Override
    public void checkElementAndPlace(Iterable<Something> records, Predicate<Something> shouldNotify) {
        records.forEach(r -> {
            if (shouldNotify.test(r)) {
            }
        });
    }
}
