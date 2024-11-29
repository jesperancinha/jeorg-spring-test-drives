package org.jesperancinha.std.flash25.jpa.operators.service;

import com.ninjasquad.springmockk.MockkBean;
import org.jesperancinha.std.flash25.jpa.operators.repos.BeanRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@MockkBean(BeanRepository.class)
@TestPropertySource("classpath:beans.properties")
class BeanServiceImplPreSpringBootTest {

    @Autowired
    private BeanServiceImpl beanService;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @Autowired
    private ConfigurableApplicationContext applicationContext;

    @BeforeEach
    public void setup(){
        applicationContext.start();
    }

    @Test
    void tesGetSlogan_whenCalled_getProductionSlogan() {
        assertThat(beanService.getSlogan()).isEqualTo("This is just a slogan");
        assertThat(dataSourceUrl).isEqualTo("jdbc:h2:file:~/flash25db");
    }
}