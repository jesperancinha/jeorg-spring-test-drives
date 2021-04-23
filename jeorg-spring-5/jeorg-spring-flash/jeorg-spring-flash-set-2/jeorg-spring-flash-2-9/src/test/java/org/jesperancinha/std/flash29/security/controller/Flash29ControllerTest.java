package org.jesperancinha.std.flash29.security.controller;

import org.jesperancinha.std.flash29.security.repository.JewelRepository;
import org.jesperancinha.std.flash29.security.services.JewelService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import static java.util.Collections.singletonList;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(controllers = Flash29Controller.class)
class Flash29ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private JewelService jewelService;

    @MockBean
    private JewelRepository jewelRepository;

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
    }

    @Test
    void listJewels() {
    }

    @Test
    void jewel() {
    }

    @Test
    void removeJewel() {
    }
}