package org.jesperancinha.b2b2java8.functional.interfaces;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BiFunction2b2Test {
    @Test
    public void calculatePotentialEnergy() {
        final BiFunction2b2 biFunction2b2 = new BiFunction2b2();

        final Double result = biFunction2b2.calculatePotentialEnergy(10d, 9d);

        assertThat(result.intValue()).isEqualTo(882);
    }
}