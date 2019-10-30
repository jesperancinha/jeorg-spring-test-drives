package com.steelzack.b2b2java8.utils;

import org.junit.Test;

import java.io.ByteArrayOutputStream;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

/**
 * Created by joaofilipesabinoesperancinha on 10-05-16.
 */
public class SystemOutTest {

    public static final String THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING = "This is the sentence you are expecting!";

    @Test
    public void testSystemOut() throws Exception {

        final SystemOut systemOut = new SystemOut();
        final ByteArrayOutputStream printer = systemOut.testSystemOut();

        System.out.print(THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING);

        assertThat(printer.toString(), equalTo(THIS_IS_THE_SENTENCE_YOU_ARE_EXPECTING));
    }

}