package org.jesperancinha.b2b2java8.collections;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Collections1Test {
    private List<String> testArrayOfStrings = Arrays.asList(//
            "Eucaliptus",
            "Mint",
            "Car",
            "Uncle Bob",
            "Developers Developers",
            "No hands",
            "Pertinent"
    );

    @Test
    public void getStringsThatStartWith() {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.getStringsThatStartWith("E");

        assertThat(result1.get(0)).isEqualTo("Eucaliptus");
        assertThat(result1.size()).isEqualTo(1);
    }

    @Test
    public void getStringsThatContain() {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.getStringsThatContain("er");

        assertThat(result1.get(0)).isEqualTo("Developers Developers");
        assertThat(result1.get(1)).isEqualTo("Pertinent");
        assertThat(result1.size()).isEqualTo(2);
    }

    @Test
    public void mapToUppercaseOnlyFiletr() {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.mapToUppercaseOnlyFiletr("er");

        assertThat(result1.get(4)).isEqualTo("DevelopERs DevelopERs");
        assertThat(result1.get(6)).isEqualTo("PERtinent");
        assertThat(result1.size()).isEqualTo(7);
    }
}