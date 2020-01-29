package org.jesperancinha.b2b2java8.utils;

import org.apache.commons.lang3.StringEscapeUtils;

public class EscapeSentenceTest {

    public static String escapedSentence(final String input) {
        return StringEscapeUtils.escapeJava(input);
    }
}
