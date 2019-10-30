package org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate;

import org.jesperancinha.b2b2java8.predicates.SomeServiceInterface;
import org.jesperancinha.b2b2java8.predicates.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.function.Predicate;

/**
 * Created by joao on 13-5-16.
 */
@Component
public class SomethingService implements SomeServiceInterface {

    @Autowired
    private PredicateConfiguration predicateConfiguration;

    @Override
    public void checkElementAndPlace(Iterable<Something> records, Predicate<Something> shouldNotify) {
        records.forEach(r -> {
            if (shouldNotify.test(r)) {
                predicateConfiguration.getDoneWith().add(r.getName());
            }
        });
    }
}
