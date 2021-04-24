package org.jesperancinha.std.flash29.security.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.std.flash29.security.domain.Jewel;
import org.jesperancinha.std.flash29.security.dto.JewelDto;
import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.jesperancinha.std.flash29.security.services.JewelService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static java.util.Collections.singletonList;
import static org.jesperancinha.std.flash29.security.services.JewelType.EMERALD;
import static org.jesperancinha.std.flash29.security.services.JewelType.RUBY;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.reset;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

/**
 * Tests for the controller
 * We are testing all REST methods necessary to manage our jewels
 * Note that for all of the non failing cases, we always need minimally one logged in user at lease, regarless of roles or jewel posession.
 */
@WebMvcTest(controllers = Flash29Controller.class)
class Flash29ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JewelService jewelService;

    @MockBean
    private JewelRepository jewelRepository;

    @Captor
    private ArgumentCaptor<Jewel> jewelArgumentCaptor;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @BeforeEach
    public void setup() {
        reset(jewelRepository);
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testGenericHandle_whenCalled_thenReturnOwnedJewelsView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("ownedjewels"))
                .andExpect(model().attribute("name", "joao"))
                .andExpect(model().attribute("roles", singletonList(
                        new SimpleGrantedAuthority("ROLE_ADMIN"))));

        verifyNoInteractions(jewelRepository);
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testListJewels_whenSimpleAuthentication_thenStillAbleToGetList() throws Exception {
        final var listOfJewels = List.of(
                JewelDto.builder().jewelType(EMERALD).guardian("KittenPowers").build(),
                JewelDto.builder().jewelType(RUBY).guardian("KittenStrongSword").build()
        );

        when(jewelService.getAll()).thenReturn(listOfJewels);

        mockMvc.perform(get("/jewels"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(listOfJewels)));

        verify(jewelService, only()).getAll();
        verifyNoInteractions(jewelRepository);

    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testJewel_whenFetchingById_thenReturnMatchingJewel() throws Exception {
        final JewelDto jewelDto = JewelDto.builder().jewelType(EMERALD).guardian("KittenPowers").build();
        when(jewelService.getJewelById(1L)).thenReturn(jewelDto);

        mockMvc.perform(get("/jewels/1"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(jewelDto)));

        verify(jewelService, only()).getJewelById(1L);
        verifyNoInteractions(jewelRepository);
    }

    @Test
    void removeJewel() {
    }
}