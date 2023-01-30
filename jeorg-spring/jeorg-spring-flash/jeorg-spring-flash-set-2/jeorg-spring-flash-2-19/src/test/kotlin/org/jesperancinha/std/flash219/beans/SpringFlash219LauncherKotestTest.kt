package org.jesperancinha.std.flash219.beans

import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import java.time.LocalDateTime
import java.util.*

@SpringBootTest
internal class SpringFlash219LauncherKotestTest {
    @Test
    fun `should initialize application content`(): Unit = runBlocking {
        listOf("a", "b", "c", "d", "e", "f", "g", "h", "i", "j").chunked(2).flatMap { chunk ->
            val chunkId = UUID.randomUUID()
            chunk.map {
                async {
                    delay((Math.random() * 100).toLong())
                    ConsolerizerComposer.outSpace()
                        .orange("Chunk $chunkId run at ${LocalDateTime.now()} with letter $it")
                        .reset()
                }
            }
        }.awaitAll()
    }
}