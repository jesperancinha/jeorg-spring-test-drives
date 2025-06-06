package org.jesperancinha.sftd.flash45.context;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
class EnjoyTheSilenceControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testHomeWhenSilenceThenEnjoy() throws Exception {
        mockMvc.perform(get("/"))
                .andExpect(status().isOk());
    }
}