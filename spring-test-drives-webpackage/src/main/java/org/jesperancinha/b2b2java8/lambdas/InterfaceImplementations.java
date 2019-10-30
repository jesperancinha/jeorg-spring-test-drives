package org.jesperancinha.b2b2java8.lambdas;

/**
 * Created by joaofilipesabinoesperancinha on 05-04-16.
 */
public class InterfaceImplementations {
    final Communication communication1 = message ->
            "Hello1 " + message;
    final Communication communication2 = (message) ->
            "Hello2 " + message;
    final Calculation2 division = (int ab, int bb) -> ab / bb;
    final Calculation2 multiplication = (int a, int b) ->
            a * b;
    final Calculation2 subtraction = (a, b) -> a - b;
    final Calculation4 addition4 = (int a, int b, int c, int d) -> a + b + c + d;
    final Calculation2 additionDouble = (int ab, int bb) -> 2 * ab + 2 * bb;
    final Calculation2 addition = (int a, int b) -> a + b;

    protected String communicationService1() {
        return communication1.communicate("This is a shining day for message two!");
    }

    protected String communicationService2() {
        return communication2.communicate("This is shining day for message one!");
    }

    protected int divisionAB(int a, int b) {
        return division.operation(a, b);
    }

    protected int multiplictionAB(int ai, int bi) {
        return multiplication.operation(ai, bi);
    }

    protected int subtractionAB(int ai, int bi) {
        return subtraction.operation(ai, bi);
    }

    protected int additionABCD(int ai, int bi, int ci, int di) {
        return addition4.operation(ai, bi, ci, di);
    }

    protected int doubleAddition(int a, int b) {
        return additionDouble.operation(a, b);
    }

    protected int additionAB(int ai, int bi) {
        return addition.operation(ai, bi);
    }

    interface Calculation2 {
        int operation(int a, int b);
    }

    interface Calculation4 {
        int operation(int a, int b, int c, int d);
    }

    interface Communication {
        String communicate(String message);
    }
}
