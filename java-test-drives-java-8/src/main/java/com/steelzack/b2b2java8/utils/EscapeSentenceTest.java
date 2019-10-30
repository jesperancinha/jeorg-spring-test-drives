package com.steelzack.b2b2java8.utils;

import org.apache.commons.lang3.StringEscapeUtils;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class EscapeSentenceTest {


    public static String escapedSentence(final String input)
    {
        return StringEscapeUtils.escapeJava(input);
    }
}
