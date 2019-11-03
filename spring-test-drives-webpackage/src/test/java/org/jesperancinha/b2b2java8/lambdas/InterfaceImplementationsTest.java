package org.jesperancinha.b2b2java8.lambdas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterfaceImplementationsTest {
    @Test
    public void doubleAddition() throws Exception {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertThat(interfaceImplementations.doubleAddition(5, 10)).isEqualTo(30);
    }

    @Test
    public void divisionAB() throws Exception {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertThat(interfaceImplementations.divisionAB(20, 10)).isEqualTo(2);
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