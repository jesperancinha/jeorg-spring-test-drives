package org.jesperancinha.b2b2java8.concurrency;

import org.junit.jupiter.api.Test;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class StampedLock1Test {
    @Test
    public void runStampedLockExample1() {
        final StampedLock1 stampedLock1 = new StampedLock1();
        stampedLock1.runStampedLockExample1();
    }

}