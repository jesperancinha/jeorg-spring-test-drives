package org.jesperancinha.std.flash43.security.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.redirectedUrl;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@SpringBootTest
@AutoConfigureMockMvc
class SpringFlash43LauncherTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void testLoginPage_whenNoAuthentication_thenAllow() throws Exception {
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk());
    }

    @Test
    void testPasswordEncoder_whenInjected_thenNotNull() {
        assertThat(passwordEncoder).isNotNull();
    }

    @Test
    void testRevealSecret_whenCalledWithoutAuthentication_thenRedirect() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(username = "joao", roles = "ADMIN")
    void testRevealSecret_whenCalledWithAdmin_thenForbidden() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "joao", roles = "USER")
    void testRevealSecret_whenCalledWithUser_thenOk() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }

    @Test
    void testRevealPartOfTheSecret_whenCalledWithoutAuthentication_thenRedirect() throws Exception {
        mockMvc.perform(get("/origin"))
                .andExpect(status().is3xxRedirection())
                .andExpect(redirectedUrl("http://localhost/login"));
    }

    @Test
    @WithMockUser(username = "joao", roles = "USER")
    void testRevealPartOfTheSecret_whenCalledWithUser_thenForbidden() throws Exception {
        mockMvc.perform(get("/origin"))
                .andExpect(status().isForbidden());
    }

    @Test
    @WithMockUser(username = "joao", roles = "ADMIN")
    void testRevealPartOfTheSecret_whenCalledWithAdmin_thenOk() throws Exception {
        mockMvc.perform(get("/origin"))
                .andExpect(status().isOk())
                .andExpect(view().name("index"));
    }
    @Test
    void testContext() {
    }
}