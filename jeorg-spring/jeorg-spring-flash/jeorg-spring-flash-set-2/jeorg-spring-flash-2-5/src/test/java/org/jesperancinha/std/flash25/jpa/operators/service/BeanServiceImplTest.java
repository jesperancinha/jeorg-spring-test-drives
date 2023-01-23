package org.jesperancinha.std.flash25.jpa.operators.service;

import org.jesperancinha.std.flash25.jpa.operators.repos.BeanRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.assertj.core.api.Assertions.assertThat;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = {BeanServiceImpl.class})
@MockBean(BeanRepository.class)
@TestPropertySource("classpath:application.properties")
class BeanServiceImplTest {

    @Autowired
    private BeanServiceImpl beanService;

    @Test
    void tesGetSlogan_whenCalled_getProductionSlogan() {
        assertThat(beanService.getSlogan()).isEqualTo("Beans are the best!");
    }
}