package org.jesperancinha.std.flash3.persistence

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
internal class SpringFlash3KotlinLauncherTest {
    @Test
    fun `should test and run context`() {
        ConsolerizerComposer.outSpace()
            .yellow("We provide the annotation this way:")
            .blue(
                """
                              <dependency>
                                    <groupId>org.springframework.boot</groupId>
                                    <artifactId>spring-boot-test</artifactId>
                                    <scope>test</scope>
                                </dependency>
                                """.trimIndent()
            )
            .yellow("We provide the implementation this way:")
            .blue(
                """
                                <dependency>
                                    <groupId>org.springframework</groupId>
                                    <artifactId>spring-test</artifactId>
                                    <scope>test</scope>
                                </dependency>
                                """.trimIndent()
            )
            .reset()
    }
}