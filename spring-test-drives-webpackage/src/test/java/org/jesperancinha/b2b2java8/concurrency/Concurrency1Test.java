package org.jesperancinha.b2b2java8.concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Concurrency1Test {
    @Test
    public void getSumAndThenReset() throws Exception {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertThat(concurrency1.getSumAndThenReset()).isEqualTo(1000);
    }

    @Test
    public void getSumAndThenResetMultitask() throws Exception {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertThat(concurrency1.getSumAndThenResetMultitask()).isEqualTo(2000);
    }
}
