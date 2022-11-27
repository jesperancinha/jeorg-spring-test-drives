package org.jesperancinha.std.mastery1.french.music;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;


@SpringBootTest
@Disabled
class Mastery1FrenchMusicLauncherTest {

    @Test
    void testContext() {
        Mastery1FrenchMusicLauncher.main(new String[0]);
    }
}