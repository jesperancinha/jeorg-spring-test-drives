package org.jesperancinha.b2b2java8.predicates.withchangeoutofpredicate;

import org.jesperancinha.b2b2java8.configuration.ApplicationOkTest;
import org.jesperancinha.b2b2java8.predicates.Something;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Arrays;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joao on 14-5-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ApplicationOkTest.class)
public class PredicateMainTest {

    private static final String NAME_1 = "Name1";
    private static final String NAME_2 = "Name2";
    private static final String NAME_3 = "Name3";

    @Autowired
    private PredicateMain predicateMain;

    @Autowired
    private PredicateConfiguration predicateConfiguration;

    @Test
    public void doThePredicateMethod() throws Exception {
        assertThat(predicateMain).isNotNull();
        assertThat(predicateConfiguration).isNotNull();

        List<Something> somethings = Arrays.stream(new Something[]{
                Something.builder().name(NAME_1).build(),
                Something.builder().name(NAME_2).build(),
                Something.builder().name(NAME_3).build()
        }).collect(Collectors.toList());
        final Stack<String> stackTestName = new Stack<>();
        stackTestName.push(NAME_1);
        stackTestName.push(NAME_3);

        final List<String> stackTestRecipients = Arrays.stream(new String[]{
                NAME_1,
                NAME_2,
                NAME_3
        }).collect(Collectors.toList());

        predicateConfiguration.getDoneWith().add(NAME_1);
        predicateConfiguration.getRecipients().add(NAME_2);

        predicateMain.doThePredicateMethod(somethings);

        assertThat(predicateConfiguration.getDoneWith()).hasSize(2);
        assertThat(predicateConfiguration.getRecipients()).hasSize(3);
        predicateConfiguration.getDoneWith().forEach(s -> assertThat(s).isEqualTo(stackTestName.pop()));
        predicateConfiguration.getRecipients().forEach(s -> assertThat(stackTestRecipients).contains(s));
    }

}
