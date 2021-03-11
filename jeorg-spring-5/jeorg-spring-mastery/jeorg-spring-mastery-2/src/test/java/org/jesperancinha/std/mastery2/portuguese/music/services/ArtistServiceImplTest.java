package org.jesperancinha.std.mastery2.portuguese.music.services;

import org.jesperancinha.std.mastery2.portuguese.music.api.ArtistService;
import org.jesperancinha.std.mastery2.portuguese.music.model.Artist;
import org.jesperancinha.std.mastery2.portuguese.music.repositories.ArtistRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Transactional
@SpringBootTest
@ContextConfiguration
@ExtendWith(SpringExtension.class)
class ArtistServiceImplTest {

    @Autowired
    private ArtistService artistService;

    @Autowired
    private ArtistRepository artistRepository;

    @BeforeEach
    public void setUp() {
        final var artist = new Artist();
        artist.setName("António Variações");
        artist.setNationality("Portuguese");
        artistRepository.save(artist);
    }


    @Test
    void testListArtists_whenListAll_thenGetAList() {
        final var artists = artistService.listArtists();

        assertThat(artists).hasSize(1);
        final Artist actual = artists.get(0);
        assertThat(actual.getName()).isEqualTo("António Variações");
        assertThat(actual.getNationality()).isEqualTo("Portuguese");

    }

    @Test
    void testGetArtistByNameUnauthenticated_whenGetArtist_thenFail() {

        Assertions.assertThrows(AuthenticationCredentialsNotFoundException.class
                , () -> artistService.getArtistByName("António"));
    }

    @Test
    @WithMockUser
    void testGetArtistByNameUnauthorizer_whenGetArtist_thenGetArtist() {
        Assertions.assertThrows(AccessDeniedException.class
                , () -> artistService.getArtistByName("António"));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = "ADMIN", value = "admin")
    void testGetArtistByName_whenGetArtist_thenGetArtist() {
        final var actual = artistService.getArtistByName("António");

        assertThat(actual.getName()).isEqualTo("António Variações");
        assertThat(actual.getNationality()).isEqualTo("Portuguese");
    }
}