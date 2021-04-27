package org.jesperancinha.std.flash33.rollback.transactional.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.std.flash33.rollback.transactional.dto.EpisodeDto;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.services.EpisodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EpisodeDtoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private EpisodeService episodeService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    void testCreateEpisode_whenPerformingPost_thenReturnNothing() throws Exception {
        final EpisodeDto episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisode(episodeDto);
    }

    @Test
    void testCreateEpisode_whenServiceFail_thenErrorAndReturnNothing() throws Exception {
        final EpisodeDto episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new EpisodeException()).when(episodeService).createEpisode(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisode")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(EpisodeException.class)
                .hasMessage("Request processing failed; nested exception is org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException");

        verify(episodeService, only()).createEpisode(episodeDto);
    }

    @Test
    void createEpisodeExceptionRollback() {
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