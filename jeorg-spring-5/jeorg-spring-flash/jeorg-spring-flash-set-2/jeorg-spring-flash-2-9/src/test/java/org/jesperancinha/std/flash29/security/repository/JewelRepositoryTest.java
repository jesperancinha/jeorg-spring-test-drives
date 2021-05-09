package org.jesperancinha.std.flash29.security.repository;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.transaction.Transactional;

import static javax.transaction.Transactional.TxType.REQUIRED;
import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.std.flash29.security.services.JewelType.AMETHYST;
import static org.jesperancinha.std.flash29.security.services.JewelType.DIAMOND;
import static org.jesperancinha.std.flash29.security.services.JewelType.RUBY;

@DataJpaTest
class JewelRepositoryTest {

    @Autowired
    private JewelRepository jewelRepository;

    @BeforeEach
    @Transactional
    public void setUp() {
        final Jewel jewel = jewelRepository.save(Jewel.builder()
                .jewelType(DIAMOND)
                .guardian("sabino").build());

        assertThat(jewel).isNotNull();
        assertThat(jewel.getId()).isNotNull();
        assertThat(jewel.getJewelType()).isEqualTo(DIAMOND);
        assertThat(jewel.getGuardian()).isEqualTo("sabino");
    }

    @Test
    public void testGetJewelWhenReadingJewelThenResultInJewel() {
        final var jewel = jewelRepository.getOne(1L);
        final var jewel2 = jewelRepository.getOne(2L);

        assertThat(jewel).isNotNull();
        assertThat(jewel.getGuardian()).isEqualTo("admin");
        assertThat(jewel.getJewelType()).isEqualTo(AMETHYST);
        assertThat(jewel2).isNotNull();
        assertThat(jewel2.getGuardian()).isEqualTo("sabino");
        assertThat(jewel2.getJewelType()).isEqualTo(DIAMOND);
    }

    @Test
    @Transactional(REQUIRED)
    public void testSaveJewelWhenCreatingThenGetId() {
        final Jewel jewel = jewelRepository.save(Jewel.builder()
                .jewelType(RUBY)
                .guardian("joao").build());

        assertThat(jewel).isNotNull();
        assertThat(jewel.getId()).isNotNull();
        assertThat(jewel.getJewelType()).isEqualTo(RUBY);
        assertThat(jewel.getGuardian()).isEqualTo("joao");
    }

}