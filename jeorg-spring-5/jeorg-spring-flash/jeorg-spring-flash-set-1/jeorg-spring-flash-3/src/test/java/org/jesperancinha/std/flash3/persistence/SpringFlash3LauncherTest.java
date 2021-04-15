package org.jesperancinha.std.flash3.persistence;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringFlash3LauncherTest {

    @Test
    public void testContext() {
        ConsolerizerComposer.outSpace()
                .yellow("We provide the annotation this way:")
                .blue("      <dependency>\n" +
                        "            <groupId>org.springframework.boot</groupId>\n" +
                        "            <artifactId>spring-boot-test</artifactId>\n" +
                        "            <scope>test</scope>\n" +
                        "        </dependency>")
                .yellow("We provide the implementation this way:")
                .blue("        <dependency>\n" +
                        "            <groupId>org.springframework</groupId>\n" +
                        "            <artifactId>spring-test</artifactId>\n" +
                        "            <scope>test</scope>\n" +
                        "        </dependency>")
                .reset();
    }

}