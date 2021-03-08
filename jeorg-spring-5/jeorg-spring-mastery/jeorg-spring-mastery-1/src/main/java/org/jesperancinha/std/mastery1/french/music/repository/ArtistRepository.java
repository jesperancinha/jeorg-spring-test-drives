package org.jesperancinha.std.mastery1.french.music.repository;

import org.jesperancinha.std.mastery1.french.music.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findArtistByNameLike(String param);
}
