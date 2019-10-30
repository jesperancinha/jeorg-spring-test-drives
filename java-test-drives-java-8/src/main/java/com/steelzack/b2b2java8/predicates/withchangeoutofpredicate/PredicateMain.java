package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import com.steelzack.b2b2java8.predicates.PredicateInterface;
import com.steelzack.b2b2java8.predicates.Something;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by joao on 13-5-16.
 */
@Component
public class PredicateMain implements PredicateInterface {

    @Autowired
    private SomethingService somethingService;

    @Autowired
    private PredicateConfiguration predicateConfiguration;

    @Override
    public void doThePredicateMethod(Iterable<Something> records) {
        somethingService.checkElementAndPlace(records,
                PredicateCustom.builder().listToFind(predicateConfiguration.getRecipients()).build()
                        .and(PredicateCustom.builder().listToFind(predicateConfiguration.getDoneWith()).build())
        );
        predicateConfiguration.getRecipients().addAll(predicateConfiguration.getDoneWith());
    }

}
