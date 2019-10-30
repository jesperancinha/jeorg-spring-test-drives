package com.steelzack.b2b2java8.repeatable.annotations;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by joaofilipesabinoesperancinha on 07-04-16.
 */

@Retention(RetentionPolicy.RUNTIME)
public @interface Flowers{
    FlowerColor[] value() default{};
}
