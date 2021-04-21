package org.jesperancinha.std.flash19.transactional.cucumber;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.jesperancinha.std.flash19.transactional.domain.Album;
import org.jesperancinha.std.flash19.transactional.repos.AlbumRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;

public class Flash19FindByAlbumSteps {

    private final AlbumRepository albumRepository;

    private List<Album> albums;
    private List<Album> searchResult;

    public Flash19FindByAlbumSteps(AlbumRepository albumRepository) {
        this.albumRepository = albumRepository;
    }

    @Given("^a lists of artists$")
    public void setup() {
        albums = new ArrayList<>();
    }

    @And("^with album: (.*) and artist: (.*) published by: (.*) in (.*)$")
    public void add(final String title, final String artist, final String publisher, final Long year) {
        final var album = new Album();
        album.setName(title);
        album.setArtist(artist);
        album.setPublisher(publisher);
        album.setYear(year);
        albums.add(album);
        albumRepository.save(album);
    }

    @When("^I search for artist: (\\w+)$")
    public void search(final String artist) {
        searchResult = albumRepository.findAlbumByArtistLike("%" + artist + "%");
        albums = albums.stream().filter(album -> album.getArtist().contains(artist)).collect(Collectors.toList());
    }

    @Then("^the result is (\\d+) records!")
    public void the_result_is(final Integer expected) {
        assertThat(searchResult).hasSize(expected);
    }

}
