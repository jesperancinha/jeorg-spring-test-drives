package org.jesperancinha.std.flash33.rollback.transactional.services.it;

import org.jesperancinha.std.flash33.rollback.transactional.dto.EpisodeDto;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.VideoCountryException;
import org.jesperancinha.std.flash33.rollback.transactional.repositories.EpisodeRepository;
import org.jesperancinha.std.flash33.rollback.transactional.services.EpisodeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

@SpringBootTest
class EpisodeServiceIT {

    @Autowired
    private EpisodeRepository episodeRepository;

    @Autowired
    private EpisodeService episodeService;

    @BeforeEach
    public void setUp(){
        episodeRepository.deleteAll();
    }

    @Test
     void testCreateEpisode_whenCreateOne_thenCallSave() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        assertThatExceptionOfType(EpisodeException.class)
                .isThrownBy(() -> episodeService.createEpisode(episodeDto));

        final var all = episodeRepository.findAll();

        assertThat(all).isNotNull();
        assertThat(all).hasSize(1);
        final var episode = all.get(0);
        assertThat(episode).isNotNull();
        assertThat(episode.getId()).isNotNull();
        assertThat(episode.getId()).isBetween(1L, 10L);
        assertThat(episode.getName()).isEqualTo(episodeDto.getName());
    }

    @Test
    void testCreateEpisodeExceptionRollback_whenCreateOne_thenCallSave() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        assertThatExceptionOfType(VideoCountryException.class)
                .isThrownBy(() -> episodeService.createEpisodeExceptionRollback(episodeDto));

        final var all = episodeRepository.findAll();

        assertThat(all).isNotNull();
        assertThat(all).hasSize(0);
    }
//
//    @Test
//    void testCreateEpisodeExceptionNoRollback_whenCreateOne_thenCallSave() {
//        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
//
//        assertThatExceptionOfType(EpisodeException.class)
//                .isThrownBy(() -> episodeService.createEpisodeExceptionNoRollback(episodeDto));
//
//        verify(episodeRepository, times(1))
//                .save(Episode.builder().id(1L).name(episodeDto.getName()).build());
//    }
//
//    @Test
//    void testCreateEpisodeMixRollback_whenCreateOne_thenCallSave() {
//        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
//
//        assertThatExceptionOfType(VideoCountryException.class)
//                .isThrownBy(() -> episodeService.createEpisodeMixRollback(episodeDto));
//
//        verify(episodeRepository, times(1))
//                .save(Episode.builder().id(1L).name(episodeDto.getName()).build());
//    }
//
//    @Test
//    void testCreateEpisodeMixNoRollback_whenCreateOne_thenCallSave() {
//        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
//
//        assertThatExceptionOfType(EpisodeException.class)
//                .isThrownBy(() -> episodeService.createEpisodeMixNoRollback(episodeDto));
//
//        verify(episodeRepository, times(1))
//                .save(Episode.builder().id(1L).name(episodeDto.getName()).build());
//    }
//
//    @Test
//    void testGetEpisodeById_whenGetById1_thenGetEpisode1() {
//        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
//        when(episodeRepository.findById(1L)).thenReturn(Optional.of(Episode.builder().id(1L).name(episodeDto.getName()).build()));
//
//        final var resultEpisodeDto = episodeService.getEpisodeById(1L);
//
//        assertThat(resultEpisodeDto).isEqualTo(episodeDto);
//
//    }
//
//    @Test
//    void getAllEpisodes() {
//        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
//        final var episodes = List.of(Episode.builder().id(1L).name(episodeDto.getName()).build());
//        when(episodeRepository.findAll()).thenReturn(episodes);
//
//        final var resultEpisodeDtos = episodeService.getAllEpisodes();
//
//        assertThat(resultEpisodeDtos).isEqualTo(List.of(episodeDto));
//    }
}