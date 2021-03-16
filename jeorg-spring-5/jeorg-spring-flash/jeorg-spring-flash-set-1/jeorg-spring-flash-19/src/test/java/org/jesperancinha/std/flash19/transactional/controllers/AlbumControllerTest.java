package org.jesperancinha.std.flash19.transactional.controllers;

import org.jesperancinha.std.flash19.transactional.domain.Album;
import org.jesperancinha.std.flash19.transactional.domain.AlbumRepository;
import org.jesperancinha.std.flash19.transactional.services.AlbumServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@MockBean(AlbumRepository.class)
@ContextConfiguration(classes = AlbumServiceImpl.class)
class AlbumControllerTest {


    @Autowired
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumServiceImpl albumService;

    @Test
    void testGetAllAlbums_whenCall_thenGetAllAlbums() {
        final List<Album> albums = new ArrayList<>();
        when(albumRepository.findAll()).thenReturn(albums);

        final List<Album> allAlbums = albumService.getAllAlbums();

        assertThat(allAlbums).isSameAs(albums);
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