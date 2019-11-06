package org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate;

import org.jesperancinha.b2b2java8.configuration.ApplicationOkTestConfiguration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = ApplicationOkTestConfiguration.class)
@ExtendWith(SpringExtension.class)
@SpringBootTest
public class SomethingServiceTest {

    @Test
    public void checkElementAndPlace() {

    }

}
