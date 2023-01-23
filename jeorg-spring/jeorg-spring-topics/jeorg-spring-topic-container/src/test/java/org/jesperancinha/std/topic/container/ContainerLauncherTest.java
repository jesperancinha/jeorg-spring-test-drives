package org.jesperancinha.std.topic.container;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

class ContainerLauncherTest {

    @Test
    void testContext() throws JsonProcessingException {
        ContainerLauncher.main(new String[0]);
    }
}