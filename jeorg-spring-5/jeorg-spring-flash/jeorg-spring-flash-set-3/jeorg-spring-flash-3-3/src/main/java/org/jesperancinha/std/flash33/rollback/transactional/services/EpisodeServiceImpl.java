package org.jesperancinha.std.flash33.rollback.transactional.services;

import org.jesperancinha.std.flash33.rollback.transactional.domain.Episode;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.repositories.EpisodeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EpisodeServiceImpl implements EpisodeService {

    private final EpisodeRepository episodeRepository;

    public EpisodeServiceImpl(EpisodeRepository episodeRepository) {
        this.episodeRepository = episodeRepository;
    }

    @Transactional(rollbackFor = RuntimeException.class, noRollbackFor = EpisodeException.class)
    @Override
    public void createEpisode(Episode episode) {
        episodeRepository.save(episode);
        throw new EpisodeException();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void createEpisodeExceptionRollback(Episode episode) {
        episodeRepository.save(episode);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackForClassName = "RuntimeException", noRollbackForClassName = "EpisodeException")
    public void createEpisodeExceptionNoRollback(Episode episode) {
        episodeRepository.save(episode);
        throw new EpisodeException();

    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, noRollbackForClassName = "EpisodeException")
    public void createEpisodeMixRollback(Episode episode) {
        episodeRepository.save(episode);
        throw new RuntimeException();
    }

    @Override
    @Transactional(rollbackFor = RuntimeException.class, noRollbackForClassName = "EpisodeException")
    public void createEpisodeMixNoRollback(Episode episode) {
        episodeRepository.save(episode);
        throw new EpisodeException();
    }

    @Override
    public Episode getEpisodeById(Long id) {
        return episodeRepository.findById(id).orElse(null);
    }

    @Override
    public List<Episode> getAllEpisodes() {
        return episodeRepository.findAll();
    }
}
