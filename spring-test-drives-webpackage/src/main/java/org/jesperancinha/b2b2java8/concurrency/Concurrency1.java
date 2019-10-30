package org.jesperancinha.b2b2java8.concurrency;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.IntStream;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Concurrency1 {

    private int sumAndResetValue;

    public Concurrency1(int sumAndResetValue) {

        this.sumAndResetValue = sumAndResetValue;
    }

    protected long getSumAndThenReset() {
        LongAdder adder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(1);

        IntStream.range(0, sumAndResetValue)
                .forEach(i -> executor.submit(adder::increment));

        StampedLock1.stop(executor);

        return adder.sumThenReset();
    }

    protected long getSumAndThenResetMultitask() {
        LongAdder adder = new LongAdder();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        IntStream.range(0, sumAndResetValue)
                .forEach(i -> {
                    executor.submit(adder::increment);
                    executor.submit(adder::increment);
                });

        StampedLock1.stop(executor);

        return adder.sumThenReset();
    }
}
