package org.jesperancinha.std.flash19.transactional.controllers;

import org.jesperancinha.std.flash19.transactional.services.AlbumService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(AlbumController.class)
class AlbumControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AlbumService albumService;

    @Test
    void getAllAlbums() {
    }

    @Test
    void createAlbum() {
    }

    @Test
    void createAlbumRollBack() {
    }

    @Test
    void updateAlbum() {
    }

    @Test
    void testCreateAlbum() {
    }
}