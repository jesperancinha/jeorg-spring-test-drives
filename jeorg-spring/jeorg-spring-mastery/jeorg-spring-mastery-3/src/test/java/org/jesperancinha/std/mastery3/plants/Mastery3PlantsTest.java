package org.jesperancinha.std.mastery3.plants;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;
import static org.jesperancinha.std.mastery3.plants.Mastery3Plants.main;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ExtendWith(SpringExtension.class)
public class Mastery3PlantsTest {

    @Test
    @Timed(millis = 1L)
    public void testContext() {
        main(new String[0]);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
    }
}