package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class EscapeSentenceTestTest {

    @Test
    public void escapedSentence() {
        assertThat(EscapeSentenceTest.escapedSentence("João")).isEqualTo("Jo\\u00E3o");
        assertThat(EscapeSentenceTest.escapedSentence("Zoë")).isEqualTo("Zo\\u00EB");
    }

}
