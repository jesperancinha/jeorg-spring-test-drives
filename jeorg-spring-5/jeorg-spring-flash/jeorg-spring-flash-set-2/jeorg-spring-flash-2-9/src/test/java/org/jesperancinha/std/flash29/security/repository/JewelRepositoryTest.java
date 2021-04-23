package org.jesperancinha.std.flash29.security.repository;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.std.flash29.security.services.JewelType.AMETHYST;

@DataJpaTest
class JewelRepositoryTest {

    @Autowired
    private JewelRepository jewelRepository;

    @Test
    @Transactional
    public void testSaveJewel() {
        final Jewel jewel = jewelRepository.save(Jewel.builder()
                .jewelType(AMETHYST)
                .guardian("joao").build());

        assertThat(jewel).isNotNull();
        assertThat(jewel.getId()).isNotNull();
        assertThat(jewel.getJewelType()).isEqualTo(AMETHYST);
        assertThat(jewel.getGuardian()).isEqualTo("joao");
    }

}