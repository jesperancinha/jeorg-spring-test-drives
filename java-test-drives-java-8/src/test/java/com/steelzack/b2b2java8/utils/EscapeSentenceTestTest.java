package com.steelzack.b2b2java8.utils;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

import org.junit.Test;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class EscapeSentenceTestTest {

    @Test
    public void escapedSentence() throws Exception {
        assertThat(EscapeSentenceTest.escapedSentence("João"), equalTo("Jo\\u00E3o"));
        assertThat(EscapeSentenceTest.escapedSentence("Zoë"), equalTo("Zo\\u00EB"));
    }

}
