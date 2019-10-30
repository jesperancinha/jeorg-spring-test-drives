package com.steelzack.b2b2java8.concurrency;

import org.junit.Test;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class StampedLock1Test {
    @Test
    public void runStampedLockExample1() throws Exception {
        final StampedLock1 stampedLock1 = new StampedLock1();
        stampedLock1.runStampedLockExample1();
    }

}