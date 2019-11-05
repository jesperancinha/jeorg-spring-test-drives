package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joaofilipesabinoesperancinha on 10-05-16.
 */
public class SystemOutTest {

    public static final String THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING = "This is the sentence you are expecting!";

    @Test
    public void testSystemOut() {

        final SystemOut systemOut = new SystemOut();
        final ByteArrayOutputStream printer = systemOut.testSystemOut();

        System.out.print(THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING);

        assertThat(printer.toString()).isEqualTo(THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING);
    }

}