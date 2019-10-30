package com.steelzack.b2b2java8.functional.interfaces;

import com.steelzack.tests.logs.LoggerInfoTest;
import org.junit.Test;

import java.util.function.BiConsumer;

/**
 * Created by joaofilipesabinoesperancinha on 23-04-16.
 */
public class BiConsumer2b2Test extends LoggerInfoTest {

    private static final String BI_CONSUMER2B2_NUMBER_1_IS_DONE_2_3 = "biConsumer2b2 number 1 is done! 2 3";
    private static final String BI_CONSUMER2B2_NUMBER_2_IS_DONE_2_3 = "biConsumer2b2 number 2 is done! 2 3";
    private static final String BI_CONSUMER2B2_NUMBER_1_IS_DONE_STRING1_STRING2 = "biConsumer2b2 number 1 is done! string1 string2";
    private static final String BI_CONSUMER2B2_NUMBER_2_IS_DONE_STRING1_STRING2 = "biConsumer2b2 number 2 is done! string1 string2";

    public BiConsumer2b2Test() {
        super(BiConsumer2b2.class);
    }

    @Test
    public void getBiConsumer1() throws Exception {
        final BiConsumer2b2<Integer, Integer> biConsumer2b2 = new BiConsumer2b2<>();
        final BiConsumer<Integer, Integer> consumer1 = biConsumer2b2.getBiConsumer1();
        final BiConsumer<Integer, Integer> consumer2 = biConsumer2b2.getBiConsumer2();
        consumer1.andThen(consumer2).accept(2, 3);

        final BiConsumer2b2<String, String> biConsumer2b21 = new BiConsumer2b2<>();
        final BiConsumer<String, String> consumer1String = biConsumer2b21.getBiConsumer1();
        final BiConsumer<String, String> consumer2String = biConsumer2b21.getBiConsumer2();
        consumer1String.andThen(consumer2String).accept("string1", "string2");

        assertLogOrder( //
                BI_CONSUMER2B2_NUMBER_1_IS_DONE_2_3, //
                BI_CONSUMER2B2_NUMBER_2_IS_DONE_2_3, //
                BI_CONSUMER2B2_NUMBER_1_IS_DONE_STRING1_STRING2, //
                BI_CONSUMER2B2_NUMBER_2_IS_DONE_STRING1_STRING2 //
        ); //
    }

    @Test
    public void getBiConsumer2() throws Exception {
        final BiConsumer2b2<Integer, Integer> biConsumer2b2 = new BiConsumer2b2<>();
        final BiConsumer<Integer, Integer> consumer1 = biConsumer2b2.getBiConsumer1();
        final BiConsumer<Integer, Integer> consumer2 = biConsumer2b2.getBiConsumer2();
        consumer2.andThen(consumer1).accept(2, 3);

        final BiConsumer2b2<String, String> biConsumer2b21 = new BiConsumer2b2<>();
        final BiConsumer<String, String> consumer1String = biConsumer2b21.getBiConsumer1();
        final BiConsumer<String, String> consumer2String = biConsumer2b21.getBiConsumer2();
        consumer2String.andThen(consumer1String).accept("string1", "string2");

        assertLogOrder( //
                BI_CONSUMER2B2_NUMBER_2_IS_DONE_2_3, //
                BI_CONSUMER2B2_NUMBER_1_IS_DONE_2_3, //
                BI_CONSUMER2B2_NUMBER_2_IS_DONE_STRING1_STRING2, //
                BI_CONSUMER2B2_NUMBER_1_IS_DONE_STRING1_STRING2 //
        ); //
    }

}