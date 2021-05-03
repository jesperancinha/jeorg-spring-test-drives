package org.jesperancinha.std.flash49.actuator;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.std.flash49.actuator.oauth.domain.User;
import org.jesperancinha.std.flash49.actuator.oauth.service.UserService;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Collections;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class SpringFlash49LauncherTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @MockBean
    private UserService userService;

    private final ObjectMapper objectMapper = new ObjectMapper();

    @Captor
    private ArgumentCaptor<User> userArgumentCaptor;

    @Test
    void testContext() {
    }

    @Test
    void testEncode_whenString_thenEncode() throws Exception {
        final var mvcResult = mockMvc.perform(get("/open?encode=123456789"))
                .andExpect(status().isOk())
                .andReturn();

        final var response = mvcResult.getResponse().getContentAsString();
        assertThat(response).isNotNull();
        assertThat(response).isNotEqualTo("123456789");
        final var matches = passwordEncoder.matches("123456789", response);
        assertThat(matches).isTrue();
    }

    @Test
    void testCreateUser_whenCreateOne_thenSaveOne() throws Exception {
        mockMvc.perform(post("/open/create")
                .header("username", "joao")
                .header("password", "joao2")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk());

        verify(userService, times(1)).saveUser(userArgumentCaptor.capture());

        final var value = userArgumentCaptor.getValue();
        assertThat(value).isNotNull();
        assertThat(value.getName()).isEqualTo("joao");
        assertThat(value.getName()).isNotEqualTo("joao2");
        final boolean joao = passwordEncoder.matches("joao2", value.getPassword());
        assertThat(joao).isTrue();
        assertThat(value.getEmail()).isNull();
        assertThat(value.getDate()).isNotNull();
        assertThat(value.getRole()).isEqualTo("ROLE_ADMIN");
    }

    @Test
    @WithMockUser(username = "joao",
            roles = "ADMIN")
    void testGetAllConcerts_withAuthenticatedAdmin_thenGetAll() throws Exception {
        final var allConcerts = Collections.singletonList(
                "Nirvana - Aneurysm (Live At The Paramount, Seattle / 1991)"
        );
        mockMvc.perform(get("/concerts"))
                .andExpect(status().isOk())
                .andExpect(content().json(objectMapper.writeValueAsString(allConcerts)));
    }

    @Test
    void testActuator_whenCalled_thenNoEvents() throws Exception {
        mockMvc.perform(get("/actuator/auditevents"))
                .andExpect(content().json("{\"events\":[]}"));
    }
}