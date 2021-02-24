package org.jesperancinha.std.flash19.transactional.services;

import org.jesperancinha.std.flash19.transactional.domain.Album;

import java.util.List;

public interface AlbumService {
    boolean deleteAlbumByIdI(Long id);

    Album updateAlbum(Album album);

    Album createAlbum(String name, String artist, String publisher, Long year);

    Album createAlbumRollBack(String name, String artist, String publisher, Long year);

    List<Album> getAllAlbums();
}
