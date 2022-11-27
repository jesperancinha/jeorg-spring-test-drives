package org.jesperancinha.std.flash25.jpa.operators.service;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.flash25.jpa.operators.repos.BeanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
@MockBean(BeanRepository.class)
@TestPropertySource("classpath:beans-fixed.properties")
class BeanServiceImplDefinedPortSpringBootTest {

    @Autowired
    private BeanServiceImpl beanService;

    @Value("${spring.datasource.url}")
    private String dataSourceUrl;

    @LocalServerPort
    private Long port;

    @Test
    void tesGetSlogan_whenCalled_getProductionSlogan() {
        assertThat(beanService.getSlogan()).isEqualTo("This is just a fixed slogan");
        assertThat(dataSourceUrl).isEqualTo("jdbc:h2:file:~/flash25db");

        ConsolerizerComposer
                .outSpace()
                .cyan("Server port is %d", port)
                .reset();
    }
}