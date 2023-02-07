package org.jesperancinha.std.app1.jdbc;

import org.jesperancinha.std.app1.jdbc.containers.AbstractTestContainersKotlinIT;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@ContextConfiguration(initializers = AbstractTestContainersKotlinIT.DockerPostgresDataInitializer.class)
public class SpringApp1LauncherTest {

    @Test
    public void testContext() {

    }

}