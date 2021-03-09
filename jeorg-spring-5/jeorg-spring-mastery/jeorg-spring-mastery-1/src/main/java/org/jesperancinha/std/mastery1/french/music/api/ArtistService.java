package org.jesperancinha.std.mastery1.french.music.api;

import org.jesperancinha.std.mastery1.french.music.domain.Artist;

import java.util.List;

public interface ArtistService {
    List<Artist> getAllArtists();

    List<Artist> getArtistsLike(String param);

    void deleteArtistById(Long id);
}
