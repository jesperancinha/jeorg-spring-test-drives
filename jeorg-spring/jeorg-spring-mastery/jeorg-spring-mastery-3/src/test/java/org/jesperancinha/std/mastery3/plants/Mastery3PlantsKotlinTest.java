package org.jesperancinha.std.mastery3.plants;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Timeout;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.std.mastery3.plants.Mastery3Plants.main;

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