package org.jesperancinha.b2b2java8.predicates.withchangeinpredicate;

import lombok.Builder;
import org.jesperancinha.b2b2java8.predicates.PredicateInterface;
import org.jesperancinha.b2b2java8.predicates.Something;

import java.util.Set;

/**
 * Created by joao on 13-5-16.
 */
@Builder
public class PredicateMain implements PredicateInterface {

    private final SomethingService somethingService = new SomethingService();

    private Set<String> recipients;

    private Set<String> doneWith;

    @Override
    public void doThePredicateMethod(Iterable<Something> records) {
        somethingService.checkElementAndPlace(records, PredicateCustom.builder().doneWith(doneWith).recipients(recipients).build());
        recipients.addAll(doneWith);
    }


}
