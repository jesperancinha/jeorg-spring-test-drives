package org.jesperancinha.std.flash33.rollback.transactional.services;

import org.jesperancinha.std.flash33.rollback.transactional.domain.Episode;
import org.jesperancinha.std.flash33.rollback.transactional.dto.EpisodeDto;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.repositories.EpisodeRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = EpisodeService.class)
class EpisodeServiceTest {

    @MockBean
    private EpisodeRepository episodeRepository;

    @Autowired
    private EpisodeService episodeService;

    @Test
    void testCreateEpisode_whenCreateOne_thenCallSave() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        assertThatExceptionOfType(EpisodeException.class)
                .isThrownBy(() -> episodeService.createEpisode(episodeDto));

        verify(episodeRepository, times(1))
                .save(Episode.builder().id(1L).name(episodeDto.getName()).build());
    }

    @Test
    void testCreateEpisodeExceptionRollback_whenCreateOne_thenCallSave() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        assertThatExceptionOfType(RuntimeException.class)
                .isThrownBy(() -> episodeService.createEpisodeExceptionRollback(episodeDto));

        verify(episodeRepository, times(1))
                .save(Episode.builder().id(1L).name(episodeDto.getName()).build());
    }

    @Test
    void createEpisodeExceptionNoRollback() {
    }

    @Test
    void createEpisodeMixRollback() {
    }

    @Test
    void createEpisodeMixNoRollback() {
    }

    @Test
    void getEpisodeById() {
    }

    @Test
    void getAllEpisodes() {
    }
}