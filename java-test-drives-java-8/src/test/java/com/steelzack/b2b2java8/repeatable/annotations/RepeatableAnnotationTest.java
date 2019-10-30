package com.steelzack.b2b2java8.repeatable.annotations;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
/**
 * Created by joaofilipesabinoesperancinha on 07-04-16.
 */
public class RepeatableAnnotationTest {
    @Test
    public void getAllFlowers() throws Exception {
        final RepeatableAnnotation repeatableAnnotation = new RepeatableAnnotation();
        final FlowerColor[] expected = Flower.class.getAnnotationsByType(FlowerColor.class);
        final FlowerColor[] result = repeatableAnnotation.getAllFlowers();
        assertThat(expected).containsExactlyElementsOf(Arrays.asList(result));
    }

}