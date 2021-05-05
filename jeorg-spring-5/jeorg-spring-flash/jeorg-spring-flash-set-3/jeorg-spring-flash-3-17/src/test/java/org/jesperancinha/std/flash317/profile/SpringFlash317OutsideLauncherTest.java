package org.jesperancinha.std.flash317.profile;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest
@ActiveProfiles("outside")
class SpringFlash317OutsideLauncherTest {

    @Test
    void testContext() {
    }
}