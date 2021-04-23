package org.jesperancinha.std.flash29.security.services;

import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.jesperancinha.std.flash29.security.services.JewelType.DIAMOND;
import static org.jesperancinha.std.flash29.security.services.JewelType.PEARL;
import static org.jesperancinha.std.flash29.security.services.JewelType.RUBY;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.when;

@SpringBootTest
class JewelServiceGetAllIT {

    @Autowired
    private JewelService jewelService;

    @MockBean
    private JewelRepository jewelRepository;

    @BeforeEach
    public void setUp() {
        reset(jewelRepository);
        when(jewelRepository.save(any())).thenAnswer(invocationOnMock -> invocationOnMock.getArguments()[0]);
        final var gregoryJewel = Jewel.builder().jewelType(PEARL).guardian("gregory_kitten").build();
        final var megaKittenJewel = Jewel.builder().jewelType(DIAMOND).guardian("MegaKitten").build();
        final var joaoJewel = Jewel.builder().jewelType(RUBY).guardian("Joao").build();
        final var jewelList = List.of(gregoryJewel, megaKittenJewel, joaoJewel);
        when(jewelRepository.findAll()).thenReturn(jewelList);
    }

    @Test
    void testGetAll_whenNoAuthentication_thenStillListAll() {
        final List<JewelDto> all = jewelService.getAll();

        assertThat(all).isNotNull();
        assertThat(all).hasSize(3);
        final JewelDto gregoryJewel = all.get(0);
        final JewelDto megaKittenJewel = all.get(1);
        final JewelDto joaoJewel = all.get(2);
        assertThat(gregoryJewel).isNotNull();
        assertThat(megaKittenJewel).isNotNull();
        assertThat(joaoJewel).isNotNull();
        assertThat(gregoryJewel.getGuardian()).isEqualTo("gregory_kitten");
        assertThat(gregoryJewel.getJewelType()).isEqualTo(PEARL);
        assertThat(megaKittenJewel.getGuardian()).isEqualTo("MegaKitten");
        assertThat(megaKittenJewel.getJewelType()).isEqualTo(DIAMOND);
        assertThat(joaoJewel.getGuardian()).isEqualTo("Joao");
        assertThat(joaoJewel.getJewelType()).isEqualTo(RUBY);
    }

}