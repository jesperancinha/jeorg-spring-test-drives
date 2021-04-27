package org.jesperancinha.std.flash33.rollback.transactional.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.std.flash33.rollback.transactional.dto.EpisodeDto;
import org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException;
import org.jesperancinha.std.flash33.rollback.transactional.services.EpisodeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doThrow;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
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
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisode")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisode(episodeDto);
    }

    @Test
    void testCreateEpisode_whenServiceFail_thenErrorAndReturnNothing() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new EpisodeException()).when(episodeService).createEpisode(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisode")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(EpisodeException.class)
                .hasMessage("Request processing failed; nested exception is org.jesperancinha.std.flash33.rollback.transactional.exceptions.EpisodeException");

        verify(episodeService, only()).createEpisode(episodeDto);
    }

    @Test
    void testCreateEpisodeExceptionRollback_whenPerformingPost_thenReturnNothing() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisodeExceptionRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisodeExceptionRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeExceptionRollback_whenServiceFail_thenErrorAndReturnNothing() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new RuntimeException()).when(episodeService).createEpisodeExceptionRollback(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisodeExceptionRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(RuntimeException.class)
                .hasMessage("Request processing failed; nested exception is java.lang.RuntimeException");

        verify(episodeService, only()).createEpisodeExceptionRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeExceptionNoRollback_whenPerformingPost_thenReturnNothing() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisodeExceptionNoRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisodeExceptionNoRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeExceptionNoRollback_whenServiceFail_thenErrorAndReturnNothing() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new RuntimeException()).when(episodeService).createEpisodeExceptionNoRollback(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisodeExceptionNoRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(RuntimeException.class)
                .hasMessage("Request processing failed; nested exception is java.lang.RuntimeException");

        verify(episodeService, only()).createEpisodeExceptionNoRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeMixRollback_whenPerformingPost_thenReturnNothing() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisodeMixRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisodeMixRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeMixRollback_whenServiceFail_thenErrorAndReturnNothing() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new RuntimeException()).when(episodeService).createEpisodeMixRollback(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisodeMixRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(RuntimeException.class)
                .hasMessage("Request processing failed; nested exception is java.lang.RuntimeException");

        verify(episodeService, only()).createEpisodeMixRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeMixNoRollback_whenPerformingPost_thenReturnNothing() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();

        mockMvc.perform(post("/createEpisodeMixNoRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto)))
                .andExpect(status().isOk())
                .andExpect(content().string(""));

        verify(episodeService, only()).createEpisodeMixNoRollback(episodeDto);
    }

    @Test
    void testCreateEpisodeMixNoRollback_whenServiceFail_thenErrorAndReturnNothing() {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        doThrow(new RuntimeException()).when(episodeService).createEpisodeMixNoRollback(episodeDto);

        assertThatThrownBy(() -> mockMvc.perform(post("/createEpisodeMixNoRollback")
                .contentType(APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(episodeDto))))
                .hasCauseInstanceOf(RuntimeException.class)
                .hasMessage("Request processing failed; nested exception is java.lang.RuntimeException");

        verify(episodeService, only()).createEpisodeMixNoRollback(episodeDto);
    }

    @Test
    void testGetEpisodeById_whenCall_thenGetEpisode1() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        when(episodeService.getEpisodeById(1L)).thenReturn(episodeDto);

        mockMvc.perform(MockMvcRequestBuilders.get("/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(episodeDto)));
    }

    @Test
    void testGetAllEpisodes_whenCalled_thenReturnList() throws Exception {
        final var episodeDto = EpisodeDto.builder().id(1L).name("The eyes see more").build();
        final var episodeDtos = List.of(episodeDto);
        when(episodeService.getAllEpisodes()).thenReturn(episodeDtos);

        mockMvc.perform(MockMvcRequestBuilders.get("/"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(episodeDtos)));
    }
}