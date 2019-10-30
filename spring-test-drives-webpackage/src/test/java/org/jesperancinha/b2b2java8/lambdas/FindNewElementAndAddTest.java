package org.jesperancinha.b2b2java8.lambdas;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joao on 15-5-16.
 */
public class FindNewElementAndAddTest {

    private static final String STR_1 = "STR1";
    private static final String STR_2 = "STR2";
    private static final String STR_3 = "STR3";
    private static final String STR_4 = "STR4";
    private static final String STR_5 = "STR5";
    private static final String STR_6 = "STR6";

    @Test
    public void generateFirstRow() throws Exception {

        final String[] array1 = Arrays.asList(STR_1, STR_2, STR_3, STR_4, STR_5).toArray(new String[0]);
        final String[] array2 = Arrays.asList(STR_1, STR_2, STR_3, STR_4, STR_6).toArray(new String[0]);

        final FindNewElementAndAdd findNewElementAndAdd = FindNewElementAndAdd.builder().rowList(
                Arrays.asList(
                        array1,
                        array2
                )).build();

        final String[] expectedArray = Arrays.asList(STR_1, STR_2, STR_3, STR_4, STR_5, STR_6).toArray(new String[0]);
        final String[] result = findNewElementAndAdd.generateFirstRow(0);

        assertThat(result).isEqualTo(expectedArray);

    }

}
