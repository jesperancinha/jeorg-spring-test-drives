package org.jesperancinha.std.flash419.contexes;

import java.util.List;

public class SongObject {

    private List<String> allSongs;

    public List<String> getAllSongs() {
        return allSongs;
    }

    public void setAllSongs(List<String> allSongs) {
        this.allSongs = allSongs;
    }

    @Override
    public String toString() {
        return "SongObject{" +
                "allSongs=" + allSongs +
                '}';
    }
}
