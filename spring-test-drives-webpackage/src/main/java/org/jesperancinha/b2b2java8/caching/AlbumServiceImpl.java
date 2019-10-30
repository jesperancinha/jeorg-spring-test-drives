package org.jesperancinha.b2b2java8.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Repository;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */

@Repository("albumService")
public class AlbumServiceImpl implements AlbumService {

    @Cacheable(value = "albumCache", key = "#album")
    public Album findByAlbum(String album) {
        try {
            Thread.sleep(5000L);
        } catch (InterruptedException e) {
            throw new IllegalStateException(e);
        }
        return new Album("REM", album, 12345);
    }

}
