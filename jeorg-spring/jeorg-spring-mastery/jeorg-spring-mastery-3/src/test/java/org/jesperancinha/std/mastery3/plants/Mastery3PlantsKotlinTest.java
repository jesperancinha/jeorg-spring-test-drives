package org.jesperancinha.std.mastery3.plants;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.springframework.boot.test.context.SpringBootTest;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class Mastery3PlantsKotlinTest {

    @Test
    @Timeout(1)
    @Disabled
    public void testContextWithTimeout() {
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
    }
    @Test
    public void testContext() {
    }
}