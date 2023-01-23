package org.jesperancinha.std.flash18.aop.afterthrowing;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class SpringFlash18LauncherTest {

    @Test
    void testContext() {
        SpringFlash18Launcher.main(new String[0]);
    }
}