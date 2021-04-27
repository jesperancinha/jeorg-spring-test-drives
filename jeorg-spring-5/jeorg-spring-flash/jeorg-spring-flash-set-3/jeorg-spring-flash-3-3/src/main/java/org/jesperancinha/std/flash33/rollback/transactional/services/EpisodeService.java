package org.jesperancinha.std.flash33.rollback.transactional.services;

import org.jesperancinha.std.flash33.rollback.transactional.domain.Episode;
import org.jesperancinha.std.flash33.rollback.transactional.dto.EpisodeDto;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.repositories.EpisodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EpisodeService {

    private final EpisodeRepository episodeRepository;

    public EpisodeService(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = EpisodeException.class)
    public void createEpisode(EpisodeDto episodeDto) {
        episodeRepository.save(toData(episodeDto));
        throw new EpisodeException();
    }

    @Transactional(rollbackFor = RuntimeException.class)
    public void createEpisodeExceptionRollback(EpisodeDto episodeDto) {
        episodeRepository.save(toData(episodeDto));
        throw new RuntimeException();
    }

    @Transactional(rollbackForClassName = "RuntimeException",
            noRollbackForClassName = "EpisodeException")
    public void createEpisodeExceptionNoRollback(EpisodeDto episodeDto) {
        episodeRepository.save(toData(episodeDto));
        throw new EpisodeException();

    }

    @Transactional(rollbackFor = RuntimeException.class,
            noRollbackForClassName = "EpisodeException")
    public void createEpisodeMixRollback(EpisodeDto episodeDto) {
        episodeRepository.save(toData(episodeDto));
        throw new RuntimeException();
    }

    @Transactional(rollbackFor = RuntimeException.class,
            noRollbackForClassName = "EpisodeException")
    public void createEpisodeMixNoRollback(EpisodeDto episodeDto) {
        episodeRepository.save(toData(episodeDto));
        throw new EpisodeException();
    }

    public EpisodeDto getEpisodeById(Long id) {
        return toDto(episodeRepository.findById(id).orElse(null));
    }

    public List<EpisodeDto> getAllEpisodes() {
        return episodeRepository.findAll().stream().map(this::toDto).collect(Collectors.toList());
    }

    private EpisodeDto toDto(Episode episode) {
        return EpisodeDto.builder()
                .id(episode.getId())
                .name(episode.getName())
                .build();
    }

    private Episode toData(EpisodeDto episodeDto) {
        return Episode.builder()
                .id(episodeDto.getId())
                .name(episodeDto.getName())
                .build();
    }
}
