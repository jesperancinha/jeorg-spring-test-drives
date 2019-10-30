package org.jesperancinha.b2b2java8.repeatable.annotations;

import java.lang.annotation.Repeatable;

/**
 * Created by joaofilipesabinoesperancinha on 07-04-16.
 */
@Repeatable(value = Flowers.class)
public @interface FlowerColor {
    String value();
}
