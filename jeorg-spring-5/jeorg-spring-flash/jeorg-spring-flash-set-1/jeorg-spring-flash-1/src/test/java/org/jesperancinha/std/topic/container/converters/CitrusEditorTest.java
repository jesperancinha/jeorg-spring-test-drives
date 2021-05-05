package org.jesperancinha.std.topic.container.converters;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CitrusEditorTest {
    @Test
    void testSetAsText_whenSetText_thenTextIsOk() {
        final CitrusEditor citrusEditor = new CitrusEditor();
        citrusEditor.setAsText("lemon-123");
        final Object value = citrusEditor.getValue();

        assertThat(value).isInstanceOf(Lemon.class);
        assertThat(((Lemon) value).getSize()).isEqualTo(123);
    }
}