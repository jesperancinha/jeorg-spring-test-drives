package org.jesperancinha.b2b2java8.lambdas;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class InterfaceImplementationsTest {
    @Test
    public void doubleAddition() {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertThat(interfaceImplementations.doubleAddition(5, 10)).isEqualTo(30);
    }

    @Test
    public void divisionAB() {
        final InterfaceImplementations interfaceImplementations = new InterfaceImplementations();
        assertThat(interfaceImplementations.divisionAB(20, 10)).isEqualTo(2);
    }

    @Test
    public void communicationService1() {

    }

    @Test
    public void communicationService2() {

    }

    @Test
    public void divisionAB1() {

    }

    @Test
    public void multiplictionAB() {

    }

    @Test
    public void subtractionAB() {

    }

    @Test
    public void additionABCD() {

    }

    @Test
    public void doubleAddition1() {

    }

    @Test
    public void additionAB() {

    }
}