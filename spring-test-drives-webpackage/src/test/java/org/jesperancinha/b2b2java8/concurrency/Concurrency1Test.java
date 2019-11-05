package org.jesperancinha.b2b2java8.concurrency;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class Concurrency1Test {
    @Test
    public void getSumAndThenReset() {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertThat(concurrency1.getSumAndThenReset()).isEqualTo(1000);
    }

    @Test
    public void getSumAndThenResetMultitask() {
        final Concurrency1 concurrency1 = new Concurrency1(1000);
        assertThat(concurrency1.getSumAndThenResetMultitask()).isEqualTo(2000);
    }
}
