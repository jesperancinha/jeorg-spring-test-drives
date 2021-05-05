package org.jesperancinha.std.flash12.cors;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = Flash12Controller.class)
class Flash12ControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testSentence_whenCalled_thenShowSentence() throws Exception {
        mockMvc.perform(get("/cors"))
                .andExpect(status().isOk())
                .andExpect(content().string("When accessing from jeorg-spring-flash-12, there should be no blocking to visualization"));
    }

    @Test
    void testSentence_whenCalledWithDifferentOrigin_thenFail() throws Exception {
        mockMvc.perform(get("/cors")
                .header("Origin", "http://thissiteissomethingcopletelydifferentlocalhost.com"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Invalid CORS request"));
    }

    @Test
    void testSentenceAlways_whenCalled_thenShowSentence() throws Exception {
        mockMvc.perform(get("/always"))
                .andExpect(status().isOk())
                .andExpect(content().string("This should be blocked from the opposite url."));
    }

    @Test
    void testSentenceAlways_whenCalledDifferentOrigin_thenShowSentence() throws Exception {
        mockMvc.perform(get("/always")
                .header("Origin", "http://thissiteissomethingcopletelydifferentlocalhost.com"))
                .andExpect(status().isOk())
                .andExpect(content().string("This should be blocked from the opposite url."));
    }

    @Test
    void testSentenceProtected_whenCalled_thenShowSentence() throws Exception {
        mockMvc.perform(get("/protected"))
                .andExpect(status().isOk())
                .andExpect(content().string("When accessing from jeorg-spring-flash-12, there should be no blocking to visualization"));
    }

    @Test
    void testSentenceProtected_whenCalledDiffentOrigint_thenFail() throws Exception {
        mockMvc.perform(get("/protected")
                .header("Origin", "http://thissiteissomethingcopletelydifferentlocalhost.com"))
                .andExpect(status().isForbidden())
                .andExpect(content().string("Invalid CORS request"));
    }
}