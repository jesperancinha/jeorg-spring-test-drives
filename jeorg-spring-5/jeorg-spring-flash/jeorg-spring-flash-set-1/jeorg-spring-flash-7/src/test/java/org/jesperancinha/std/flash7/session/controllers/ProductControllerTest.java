package org.jesperancinha.std.flash7.session.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(controllers = ProductController.class)
class ProductControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetTulips_whenCalled_getResponse() throws Exception {
        final MvcResult tulips = mockMvc.perform(get("/tulips"))
                .andReturn();
        final var contentAsString = tulips.getResponse().getContentAsString();

        assertThat(contentAsString).isNotNull();
        assertThat(contentAsString).isEqualTo("You just got a bunch of tulips!");
    }

    @Test
    void testGetTulipsOk_whenCalled_getResponse() {
    }

    @Test
    void testGetTulipsError_whenCalled_getResponse() {
    }

    @Test
    void testGetFlower_whenCalled_getResponse() {
    }

    @Test
    void testGetCar_whenCalled_getResponse() {
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