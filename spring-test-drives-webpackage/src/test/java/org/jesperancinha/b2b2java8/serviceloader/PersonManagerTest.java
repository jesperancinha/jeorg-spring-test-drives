package org.jesperancinha.b2b2java8.serviceloader;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by joao on 16-5-16.
 */
public class PersonManagerTest {

    @Test
    public void getDefault() throws Exception {
        final Stack<String> personNames = new Stack<>();
        personNames.push("PersonTwo");
        personNames.push("PersonOne");

        final List<AbstractPerson> allImplementations = PersonManager.getDefault();

        assertThat(allImplementations).hasSize(2);
        allImplementations.forEach(abstractPerson -> assertThat(personNames.pop()).isEqualTo(abstractPerson.getPersonName()));

    }

}
