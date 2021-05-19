package org.jesperancinha.std.mastery3.plants;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Timed;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.RED;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringJUnit4ClassRunner.class)
public class Mastery3PlantsTestJUnit4 {

    @Test
    @Timed(millis = 100L)
    public void testContext() {
        try {
            Thread.sleep(10L);
        } catch (InterruptedException e) {
            RED.printThrowableAndExit(e);
        }
    }
}