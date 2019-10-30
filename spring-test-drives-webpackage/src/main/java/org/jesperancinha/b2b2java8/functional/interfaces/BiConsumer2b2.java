package org.jesperancinha.b2b2java8.functional.interfaces;

import lombok.Getter;

import java.text.MessageFormat;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
@Getter
public class BiConsumer2b2<X, Y> {
    static final Logger logger = Logger.getLogger(BiConsumer2b2.class.getName());
    private final BiConsumer<X, Y> biConsumer1;
    private final BiConsumer<X, Y> biConsumer2;

    public BiConsumer2b2() {
        biConsumer1 = (x, y) -> {
            logger.info(MessageFormat.format("biConsumer2b2 number 1 is done! {0} {1}", x, y));
        };

        biConsumer2 = (x, y) -> {
            logger.info(MessageFormat.format("biConsumer2b2 number 2 is done! {0} {1}", x, y));
        };
    }
}
