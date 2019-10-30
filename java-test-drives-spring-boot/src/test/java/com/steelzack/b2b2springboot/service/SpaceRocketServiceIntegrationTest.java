package com.steelzack.b2b2springboot.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.nullValue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.steelzack.b2b2springboot.config.SpaceRocketConfig;
import com.steelzack.b2b2springboot.entities.SpaceRocket;
import com.steelzack.b2b2springboot.entities.SpaceRocketRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

/**
 * Created by jesperancinha on 24-5-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpaceRocketConfig.class, loader = AnnotationConfigContextLoader.class)
public class SpaceRocketServiceIntegrationTest {

    @Autowired
    SpaceRocketService spaceRocketService;

    @Autowired
    SpaceRocketRepository spaceRocketRepository;


    @Before
    public void setUp() {
        spaceRocketService.addRocket(SpaceRocket.builder().id(2).name("Ariane1.0").engineType("A62").payLoad(5.0001).height(63).build());
        spaceRocketService.addRocket(SpaceRocket.builder().id(3).name("Ariane1.1").engineType("A64").payLoad(11.0001).height(63).build());
    }

    @After
    public void tearDown() {
        spaceRocketRepository.deleteAll();
    }

    @Test
    public void getAllRockets() throws Exception {

        final List<SpaceRocket> allRocketResult = StreamSupport.stream(spaceRocketService.getAllRockets().spliterator(), true).collect(Collectors.toList());
        assertThat(allRocketResult, hasSize(2));

    }

    @Test
    public void deleteRocket() throws Exception {

        final SpaceRocket spaceRocket = SpaceRocket.builder().id(4).name("Ariane").engineType("A64").payLoad(11.0001).height(63).build();
        spaceRocketRepository.save(spaceRocket);

        SpaceRocket rocketResult = spaceRocketRepository.findOne(4);

        assertThat(rocketResult.getId(), equalTo(4));

        spaceRocketService.deleteRocket(4);

        rocketResult = spaceRocketRepository.findOne(4);

        assertThat(rocketResult, nullValue());

    }

    @Test
    public void addRocket() throws Exception {

        final SpaceRocket spaceRocket = SpaceRocket.builder().id(1).name("Ariane").engineType("A64").payLoad(11.0001).height(63).build();
        spaceRocketService.addRocket(spaceRocket);

        final Optional<SpaceRocket> spaceRocketResult = StreamSupport.stream(spaceRocketService.getAllRockets().spliterator(), true).filter(
                spaceRocket1 -> spaceRocket1.getId() == 1
        ).findFirst();

        assertTrue(spaceRocketResult.isPresent());
        final SpaceRocket actualSpaceRocketResult = spaceRocketResult.get();
        assertThat(actualSpaceRocketResult.getName(), equalTo("Ariane"));
        assertThat(actualSpaceRocketResult.getEngineType(), equalTo("A64"));
        assertThat(actualSpaceRocketResult.getPayLoad(), equalTo(11.0001));
        assertThat(actualSpaceRocketResult.getHeight(), equalTo(63.0));

    }

}
