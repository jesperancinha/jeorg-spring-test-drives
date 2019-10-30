package com.steelzack.b2b2java8.predicates.withchangeoutofpredicate;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by joao on 14-5-16.
 */
@Component
@Getter
@NoArgsConstructor
public class PredicateConfiguration {

    private Set<String> recipients = new HashSet<>();

    private Set<String> doneWith = new HashSet<>();
            ;

}
