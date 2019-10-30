package com.steelzack.b2b2java8.functional.interfaces;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 24-04-16.
 */
public class BiFunction2b2Test {
    @Test
    public void calculatePotentialEnergy() throws Exception {
        final BiFunction2b2 biFunction2b2 = new BiFunction2b2();

       final Double result = biFunction2b2.calculatePotentialEnergy(10d, 9d);

        assertEquals(882, result ,1);
    }
}