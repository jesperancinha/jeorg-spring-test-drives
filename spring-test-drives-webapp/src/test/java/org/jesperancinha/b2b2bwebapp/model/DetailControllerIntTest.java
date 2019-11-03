package org.jesperancinha.b2b2bwebapp.model;

import org.jesperancinha.b2b2bwebapp.config.DetailConfig;
import org.jesperancinha.b2b2bwebapp.repository.DetailRepository;
import org.jesperancinha.b2b2bwebapp.service.DetailController;
import org.jesperancinha.b2b2bwebapp.service.DetailService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@Disabled
@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = DetailConfig.class, loader = AnnotationConfigContextLoader.class)
public class DetailControllerIntTest {

    private static final String NAME_1 = "Name1";
    private static final String CITY_1 = "City1";

    @Autowired
    private DetailService detailService;

    @Autowired
    private DetailController detailController;

    @Autowired
    private DetailRepository detailRepository;

    @BeforeEach
    public void setUp() {
        detailRepository.deleteAll();
        addOneElement();
    }

    private void addOneElement() {
        final DetailEntity detailEntity = DetailEntity.builder().id(1).name(NAME_1).city(CITY_1).build();
        detailRepository.save(detailEntity);
    }

    @Test
    public void findDetailById() {
        final Detail result = detailController.findDetailById(1);
        assertThat(result.getName()).isEqualTo(NAME_1);
        assertThat(result.getCity()).isNull();

        detailRepository.deleteAll();

        DetailEntity checkForNone = detailRepository.findById(1).orElseThrow();
        assertThat(checkForNone).isNull();

        final Detail resultCached = detailController.findDetailById(1);
        assertThat(resultCached.getName()).isEqualTo(NAME_1);
        assertThat(resultCached.getCity()).isNull();

        addOneElement();

        DetailEntity result2 = detailRepository.findById(1).orElseThrow();
        assertThat(result2.getName()).isEqualTo(NAME_1);
        assertThat(result2.getCity()).isNull();

        result2.setCity(CITY_1);
        assertThat(result2.getCity()).isEqualTo(CITY_1);

        DetailEntity result3 = detailRepository.findById(1).orElseThrow();
        assertThat(result3.getName()).isEqualTo(NAME_1);
        assertThat(result3.getCity()).isNull();

        List<String> test = null;

    }

}
