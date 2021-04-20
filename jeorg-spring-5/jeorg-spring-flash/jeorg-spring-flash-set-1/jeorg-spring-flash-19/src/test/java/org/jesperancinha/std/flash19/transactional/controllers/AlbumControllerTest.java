package org.jesperancinha.std.flash19.transactional.controllers;

import org.jesperancinha.std.flash19.transactional.domain.Album;
import org.jesperancinha.std.flash19.transactional.domain.AlbumRepository;
import org.jesperancinha.std.flash19.transactional.services.AlbumServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(SpringExtension.class)
@MockBean(AlbumRepository.class)
@ContextConfiguration(classes = AlbumServiceImpl.class)
class AlbumControllerTest {

    @SpyBean(AlbumRepository.class)
    private AlbumRepository albumRepository;

    @Autowired
    private AlbumServiceImpl albumService;

    @Captor
    private ArgumentCaptor<Album> albumArgumentCaptor;

    @Test
    void testGetAllAlbums_whenCall_thenGetAllAlbums() {
        final List<Album> albums = new ArrayList<>();
        when(albumRepository.findAll()).thenReturn(albums);

        final List<Album> allAlbums = albumService.getAllAlbums();

        assertThat(allAlbums).isSameAs(albums);
    }

    @Test
    void testCreateAlbumRollBack_whenCall_thenSimulatePerformARollback() {
        assertThrows(RuntimeException.class,()->
                albumService.createAlbumRollBack(
                        "The Downward Spiral", "Nine Inch Nails", "Nothing Records", 1995L));

        verify(albumRepository, times(1)).save(albumArgumentCaptor.capture());
        final Album value = albumArgumentCaptor.getValue();
        assertThat(value.getId()).isNull();
        assertThat(value.getName()).isEqualTo("The Downward Spiral");
        assertThat(value.getArtist()).isEqualTo("Nine Inch Nails");
        assertThat(value.getPublisher()).isEqualTo("Nothing Records");
        assertThat(value.getYear()).isEqualTo(1995L);
    }

    @Test
    void updateAlbum() {
    }

    @Test
    void testCreateAlbum() {
    }
}