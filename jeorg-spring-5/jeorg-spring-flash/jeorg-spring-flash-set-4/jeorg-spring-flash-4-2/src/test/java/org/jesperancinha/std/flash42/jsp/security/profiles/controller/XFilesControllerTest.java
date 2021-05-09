package org.jesperancinha.std.flash42.jsp.security.profiles.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest
class XFilesControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @WithMockUser(username = "joao")
    void testGenericHandleWhenCalledWithUserThenRightModelAndView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("userdata"))
                .andExpect(model().attribute("name", "joao"))
                .andExpect(model().attribute("roles",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_USER"))));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testGenericHandleWhenCalledWithAdminThenRightModelAndView() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("userdata"))
                .andExpect(model().attribute("name", "joao"))
                .andExpect(model().attribute("roles",
                        Collections.singletonList(new SimpleGrantedAuthority("ROLE_ADMIN"))));
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "SOMETHING")
    void testGenericHandleWhenCalledWithSomethingThenAuthorizationDenied() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isForbidden());
    }
}