package org.jesperancinha.b2b2java8.predicates.withchangeinpredicate;

import org.jesperancinha.b2b2java8.predicates.Something;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.stream.Collectors;

import static org.assertj.core.api.Java6Assertions.assertThat;

/**
 * Created by joao on 14-5-16.
 */
public class PredicateMainTest {

    public static final String NAME_1 = "Name1";
    public static final String NAME_2 = "Name2";
    public static final String NAME_3 = "Name3";

    @Test
    public void doThePredicateMethod() throws Exception {

        List<Something> somethings = Arrays.stream(new Something[]{
                Something.builder().name(NAME_1).build(),
                Something.builder().name(NAME_2).build(),
                Something.builder().name(NAME_3).build()
        }).collect(Collectors.toList());

        final Set<String> doneWith = new HashSet<>();
        final Set<String> recipients = new HashSet<>();
        doneWith.add(NAME_1);
        recipients.add(NAME_2);

        final PredicateMain predicateMain = PredicateMain.builder().doneWith(doneWith).recipients(recipients).build();

        final Stack<String> stackTestName = new Stack<>();
        stackTestName.push(NAME_1);
        stackTestName.push(NAME_3);

        final List<String> stackTestRecipients = Arrays.stream(new String[]{
                NAME_1,
                NAME_2,
                NAME_3
        }).collect(Collectors.toList());

        predicateMain.doThePredicateMethod(somethings);

        assertThat(doneWith).hasSize(2);
        assertThat(recipients).hasSize(3);
        doneWith.forEach(s -> assertThat(s).isEqualTo(stackTestName.pop()));
        recipients.forEach(s -> assertThat(stackTestRecipients).contains(s));

    }

}
