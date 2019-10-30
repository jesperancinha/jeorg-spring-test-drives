package com.steelzack.b2b2java8.serviceloader;

import org.junit.Test;

import java.util.List;
import java.util.Stack;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;

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

        assertThat(allImplementations, hasSize(2));
        allImplementations.forEach(
                abstractPerson -> assertThat(abstractPerson.getPersonName(), equalTo(personNames.pop()))
        );

    }

}
