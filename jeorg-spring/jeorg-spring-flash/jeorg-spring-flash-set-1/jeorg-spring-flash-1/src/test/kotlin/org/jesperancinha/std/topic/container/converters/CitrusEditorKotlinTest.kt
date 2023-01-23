package org.jesperancinha.std.topic.container.converters

import io.kotest.matchers.shouldBe
import io.kotest.matchers.types.shouldBeTypeOf
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

internal class CitrusEditorKotlinTest {
    @Test
    fun testSetAsTextWhenSetTextThenTextIsOk() {
        val citrusEditor = CitrusEditor()
        citrusEditor.asText = "lemon-123"
        val value = citrusEditor.value
       (value as Lemon).size shouldBe 123
        value.shouldBeTypeOf<Lemon>()
    }
}