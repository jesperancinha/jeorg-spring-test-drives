package com.steelzack.b2b2java8.predicates;

import java.util.function.Predicate;

/**
 * Created by joao on 14-5-16.
 */
public interface SomeServiceInterface {
    void checkElementAndPlace(Iterable<Something> records, Predicate<Something> shouldNotify);
}
