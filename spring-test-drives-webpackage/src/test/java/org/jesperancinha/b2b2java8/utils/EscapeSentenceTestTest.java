package org.jesperancinha.b2b2java8.utils;

import org.junit.jupiter.api.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by jesperancinha on 12-5-16.
 */
public class EscapeSentenceTestTest {

    @Test
    public void escapedSentence() throws Exception {
        assertThat(EscapeSentenceTest.escapedSentence("João")).isEqualTo("Jo\\u00E3o");
        assertThat(EscapeSentenceTest.escapedSentence("Zoë")).isEqualTo("Zo\\u00EB");
    }

}
