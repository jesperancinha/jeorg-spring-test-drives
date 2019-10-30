package com.steelzack.b2b2java8.collections;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 06-04-16.
 */
public class Collections1Test {
    private List<String> testArrayOfStrings = Arrays.asList(//
            "Eucaliptus", //
            "Mint", //
            "Car", //
            "Uncle Bob", //
            "Developers Developers", //
            "No hands", //
            "Pertinent"
    );
    @Test
    public void getStringsThatStartWith() throws Exception {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.getStringsThatStartWith("E");

        assertEquals("Eucaliptus",result1.get(0));
        assertEquals(1, result1.size());
    }

    @Test
    public void getStringsThatContain() throws Exception {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.getStringsThatContain("er");

        assertEquals("Developers Developers",result1.get(0));
        assertEquals("Pertinent",result1.get(1));
        assertEquals(2, result1.size());
    }

    @Test
    public void mapToUppercaseOnlyFiletr() throws Exception {
        final Collections1 collections1 = new Collections1(testArrayOfStrings);

        List<String> result1 = collections1.mapToUppercaseOnlyFiletr("er");

        assertEquals("DevelopERs DevelopERs",result1.get(4));
        assertEquals("PERtinent",result1.get(6));
        assertEquals(7, result1.size());
    }
}