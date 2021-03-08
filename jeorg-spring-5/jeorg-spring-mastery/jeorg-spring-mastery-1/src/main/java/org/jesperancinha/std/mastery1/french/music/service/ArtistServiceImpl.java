package org.jesperancinha.std.mastery1.french.music.service;

import org.jesperancinha.std.mastery1.french.music.api.ArtistService;
import org.jesperancinha.std.mastery1.french.music.domain.Artist;
import org.jesperancinha.std.mastery1.french.music.repository.ArtistRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistServiceImpl implements ArtistService {

    private final ArtistRepository artistRepository;

    public ArtistServiceImpl(ArtistRepository artistRepository) {
        this.artistRepository = artistRepository;
    }

    @Override
    public List<Artist> getAllArtists() {
        return artistRepository.findAll();
    }

    @Override
    public List<Artist> getArtistsLike(String param) {
        return artistRepository.findArtistByNameLike(param);
    }
}
