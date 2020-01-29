package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EscapeSentenceTestTest {

    @Test
    public void escapedSentence() {
        assertThat(EscapeSentenceTest.escapedSentence("João")).isIn("Jo\\u00E3o", "Jo\\uFFFD\\uFFFDo");
        assertThat(EscapeSentenceTest.escapedSentence("Zoë")).isIn("Zo\\u00EB", "Zo\\uFFFD\\uFFFD");
    }

}
