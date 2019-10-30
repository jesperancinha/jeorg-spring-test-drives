package org.jesperancinha.b2b2java8.repeatable.annotations;

/**
 * Created by joaofilipesabinoesperancinha on 07-04-16.
 */
public class RepeatableAnnotation {
    public FlowerColor[] getAllFlowers() {
        FlowerColor[] a = Flower.class.getAnnotationsByType(FlowerColor.class);
        Flowers flowers = Flower.class.getAnnotation(Flowers.class);
        for (FlowerColor floweColor : flowers.value()) {
            System.out.println(floweColor.value());
        }
        return a;
    }
}
