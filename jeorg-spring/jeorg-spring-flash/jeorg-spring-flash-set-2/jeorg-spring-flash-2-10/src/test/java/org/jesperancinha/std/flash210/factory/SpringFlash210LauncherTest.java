package org.jesperancinha.std.flash210.factory;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash210.factory.configurations.Material;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringFlash210LauncherTest {

    @Autowired
    private Material material;

    @Test
    void testContext() {
        assertThat(material).isNotNull();
        final var value = material.getValue();
        assertThat(value).isEqualTo("The world is not enough!");
        ConsolerizerComposer.outSpace()
                .brightBlue()
                .jsonPrettyPrint(material)
                .reset();
        SpringFlash210Launcher.main(new String[0]);
    }
}