package org.jesperancinha.std.flash7.session.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.jesperancinha.std.flash7.session.handlers.ErrorFlower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTulips_whenCalled_getResponse() throws Exception {
        final MvcResult tulips = mockMvc.perform(get("/tulips"))
                .andExpect(status().isOk())
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();

        assertThat(contentAsString).isNotNull();
        assertThat(contentAsString).isEqualTo("You just got a bunch of tulips!");
    }

    @Test
    void testGetTulipsOk_whenCalled_getResponse() throws Exception {
        final MvcResult tulips = mockMvc.perform(get("/tulips/ok"))
                .andExpect(status().isOk())
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();
        final var errorMessage = tulips.getResponse().getErrorMessage();
        assertThat(contentAsString).isEmpty();
        assertThat(errorMessage).isEqualTo("This is an error, but it's ok");
    }

    @Test
    void testGetTulipsError_whenCalled_getResponse() throws Exception {
        final MvcResult tulips = mockMvc.perform(get("/tulips/error"))
                .andExpect(status().isServiceUnavailable())
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();
        final var errorMessage = tulips.getResponse().getErrorMessage();
        assertThat(contentAsString).isEmpty();
        assertThat(errorMessage).isEqualTo("We are not available at the moment!");
    }

    @Test
    void testGetFlower_whenCalled_getResponse() throws Exception {
        final MvcResult tulips = mockMvc.perform(get("/tulips/error"))
                .andExpect(status().isServiceUnavailable())
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();
        final var errorMessage = tulips.getResponse().getErrorMessage();
        assertThat(contentAsString).isEmpty();
        assertThat(errorMessage).isEqualTo("We are not available at the moment!");
    }

    @Test
    void testGetCar_whenCalled_getResponse() throws Exception {
        final ObjectMapper objectMapper = new ObjectMapper();
        final MvcResult tulips = mockMvc.perform(get("/flowers/rose"))
                .andExpect(status().isNotFound())
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();
        final var errorMessage = tulips.getResponse().getErrorMessage();
        assertThat(contentAsString).isNotNull();
        final ErrorFlower errorFlower = objectMapper.readValue(contentAsString, ErrorFlower.class);
        assertThat(errorFlower.getHttpStatus()).isEqualTo(HttpStatus.NOT_FOUND);
        assertThat(errorMessage).isNull();
    }

    @Test
    void testGetFlowerLocal_whenCalled_getResponse() {
    }

    @Test
    void testGetCarLocal_whenCalled_getResponse() {
    }

    @Test
    void testGetPottery_whenCalled_getResponse() {
    }

    @Test
    void testGetFourwheels_whenCalled_getResponse() {
    }
}