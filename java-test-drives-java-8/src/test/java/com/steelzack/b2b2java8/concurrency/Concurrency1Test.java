package com.steelzack.b2b2java8.concurrency;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Concurrency1Test {
    @Test
    public void getSumAndThenReset() throws Exception {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertEquals(1000,concurrency1.getSumAndThenReset());
    }

    @Test
    public void getSumAndThenResetMultitask() throws Exception {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertEquals(2000,concurrency1.getSumAndThenResetMultitask());
    }
}
