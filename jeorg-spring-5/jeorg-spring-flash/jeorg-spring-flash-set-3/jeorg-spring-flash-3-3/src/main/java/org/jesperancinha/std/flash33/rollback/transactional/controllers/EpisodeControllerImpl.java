package org.jesperancinha.std.flash33.rollback.transactional.controllers;

import org.jesperancinha.std.flash33.rollback.transactional.domain.Episode;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.services.EpisodeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
public class EpisodeControllerImpl implements EpisodeController {

    private final EpisodeService episodeService;

    public EpisodeControllerImpl(EpisodeService episodeService) {
        this.episodeService = episodeService;
    }

    @PostMapping(path = "/createEpisode",
            consumes = APPLICATION_JSON_VALUE)
    @Override
    public void createEpisode(
            @RequestBody
                    Episode episode) {
        try {
            episodeService.createEpisode(episode);
        } catch (EpisodeException exception) {
            YELLOW.printGenericLn("This exception won't trigger a rollback, please check the main listing page in path /", exception);
        }
    }

    @PostMapping(path = "/createEpisodeExceptionRollback",
            consumes = APPLICATION_JSON_VALUE)
    @Override
    public void createEpisodeExceptionRollback(
            @RequestBody
                    Episode episode) {
        try {
            episodeService.createEpisodeExceptionRollback(episode);
        } catch (RuntimeException exception) {
            YELLOW.printGenericLn("This exception will trigger a rollback, please check the main listing page in path /", exception);
        }
    }

    @PostMapping(path = "/createEpisodeExceptionNoRollback",
            consumes = APPLICATION_JSON_VALUE)
    @Override
    public void createEpisodeExceptionNoRollback(
            @RequestBody
                    Episode episode) {
        try {
            episodeService.createEpisodeExceptionNoRollback(episode);
        } catch (RuntimeException exception) {
            YELLOW.printGenericLn("This exception will trigger a rollback, please check the main listing page in path /", exception);
        }
    }

    @PostMapping(path = "/createEpisodeMixRollback",
            consumes = APPLICATION_JSON_VALUE)
    @Override
    public void createEpisodeMixRollback(
            @RequestBody
                    Episode episode) {
        try {
            episodeService.createEpisodeMixRollback(episode);
        } catch (RuntimeException exception) {
            YELLOW.printGenericLn("This exception will trigger a rollback, please check the main listing page in path /", exception);
        }
    }

    @PostMapping(path = "/createEpisodeMixNoRollback",
            consumes = APPLICATION_JSON_VALUE)
    @Override
    public void createEpisodeMixNoRollback(
            @RequestBody
                    Episode episode) {
        try {
            episodeService.createEpisodeMixNoRollback(episode);
        } catch (EpisodeException exception) {
            YELLOW.printGenericLn("This exception won't trigger a rollback, please check the main listing page in path /", exception);
        }
    }

    @GetMapping("{id}")
    @Override
    public Episode getEpisodeById(
            @PathVariable
                    Long id) {
        return episodeService.getEpisodeById(id);
    }

    @GetMapping("/")
    @Override
    public List<Episode> getAllEpisodes() {
        return episodeService.getAllEpisodes();
    }
}
