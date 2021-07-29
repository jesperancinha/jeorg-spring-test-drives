package org.jesperancinha.std.old.webapp.service;

import org.jesperancinha.std.old.webapp.model.Detail;
import org.jesperancinha.std.old.webapp.model.DetailEntity;
import org.jesperancinha.std.old.webapp.repository.DetailRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ActiveProfiles("test")
public class DetailLayer2ServiceTest {

    private static final String NAME_1 = "Name1";
    private static final String CITY_1 = "City1";

    @Autowired
    private DetailLayer2Service detailController;

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

        DetailEntity checkForNone = detailRepository.findById(1).orElse(null);
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