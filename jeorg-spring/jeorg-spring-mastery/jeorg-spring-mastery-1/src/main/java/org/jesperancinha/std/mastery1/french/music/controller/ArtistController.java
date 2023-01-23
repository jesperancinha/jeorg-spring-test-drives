package org.jesperancinha.std.mastery1.french.music.controller;

import org.jesperancinha.std.mastery1.french.music.api.ArtistService;
import org.jesperancinha.std.mastery1.french.music.domain.Artist;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("artist")
public class ArtistController {

    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
    }

    @RequestMapping
    public @ResponseBody
    List<Artist> getAllArtists() {
        return artistService.getAllArtists();
    }

    @RequestMapping("/search")
    public @ResponseBody
    List<Artist> getAllArtists(
            @RequestParam
            final String param) {
        return artistService.getArtistsLike(param);
    }

    @RequestMapping("/delete/{id}")
    public @ResponseBody
    ResponseEntity<Object> deleteArtistById(
            @PathVariable
            final Long id) {
        artistService.deleteArtistById(id);
        return ResponseEntity.ok().build();
    }
}
