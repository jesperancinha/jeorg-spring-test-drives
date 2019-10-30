package com.steelzack.b2b2java8.lambdas;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public class InterfaceImplementationsTest {
    @Test
    public void doubleAddition() throws Exception {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertEquals(30, interfaceImplementations.doubleAddition(5,10));
    }

    @Test
    public void divisionAB() throws Exception {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertEquals(2, interfaceImplementations.divisionAB(20,10));
    }

    @Test
    public void communicationService1() throws Exception {

    }

    @Test
    public void communicationService2() throws Exception {

    }

    @Test
    public void divisionAB1() throws Exception {

    }

    @Test
    public void multiplictionAB() throws Exception {

    }

    @Test
    public void subtractionAB() throws Exception {

    }

    @Test
    public void additionABCD() throws Exception {

    }

    @Test
    public void doubleAddition1() throws Exception {

    }

    @Test
    public void additionAB() throws Exception {

    }
}