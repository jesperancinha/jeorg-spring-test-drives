package com.steelzack.b2b2bwebapp.model;

import com.steelzack.b2b2bwebapp.config.DetailConfig;
import com.steelzack.b2b2bwebapp.repository.DetailRepository;
import com.steelzack.b2b2bwebapp.service.DetailController;
import com.steelzack.b2b2bwebapp.service.DetailService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * Created by joao on 15-5-16.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = DetailConfig.class, loader = AnnotationConfigContextLoader.class)
public class DetailControllerIntTest {

    private static final String NAME_1 = "Name1";
    private static final String CITY_1 = "City1";

    @Autowired
    DetailService detailService;

    @Autowired
    DetailController detailController;

    @Autowired
    DetailRepository detailRepository;

    @Before
    public void setUp() {
        detailRepository.deleteAll();
        addOneElement();
    }

    private void addOneElement() {
        final DetailEntity detailEntity = DetailEntity.builder().id(1).name(NAME_1).city(CITY_1).build();
        detailRepository.save(detailEntity);
    }

    @Test
    public void findDetailById() throws Exception {
        final Detail result = detailController.findDetailById(1);
        assertThat(result.getName(), equalTo(NAME_1));
        assertThat(result.getCity(), nullValue());

        detailRepository.deleteAll();

        DetailEntity checkForNone = detailRepository.findOne(1);
        assertThat(checkForNone, nullValue());

        final Detail resultCached = detailController.findDetailById(1);
        assertThat(resultCached.getName(), equalTo(NAME_1));
        assertThat(resultCached.getCity(), nullValue());

        addOneElement();

        DetailEntity result2 = detailRepository.findOne(1);
        assertThat(result2.getName(), equalTo(NAME_1));
        assertThat(result2.getCity(), nullValue());

        result2.setCity(CITY_1);
        assertThat(result2.getCity(), equalTo(CITY_1));

        DetailEntity result3 = detailRepository.findOne(1);
        assertThat(result3.getName(), equalTo(NAME_1));
        assertThat(result3.getCity(), nullValue());

        List<String> test = null;

    }

}
