package com.steelzack.b2b2java8.functional.interfaces;

import java.util.function.BiFunction;

import static org.jscience.physics.amount.Constants.g;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class BiFunction2b2 {
    /**
     * This is the actual BiFunction to calculate the potential energy of an element considering earth's gravity
     */
    final BiFunction<Double, Double, Double> potentialEnergyCalculator =
            (inHeight, inMass) -> inMass * inHeight * g.getEstimatedValue();

    /**
     * Returns potential energy in Joules
     *
     * @param height In meters
     * @param mass   In Kilograms
     * @return
     */
    public Double calculatePotentialEnergy(Double height, Double mass) {

        return potentialEnergyCalculator.apply(height, mass);
    }
}
