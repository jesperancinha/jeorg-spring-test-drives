package org.jesperancinha.std.flash34.annotation.web.model;

import java.util.ArrayList;
import java.util.List;

public class LyricCollection {

    public String band;

    public List<String> lyrics = new ArrayList<>();

    public String getBand() {
        return band;
    }

    public void setBand(String band) {
        this.band = band;
    }

    public List<String> getLyrics() {
        return lyrics;
    }

    public void setLyrics(List<String> lyrics) {
        this.lyrics = lyrics;
    }

    @Override
    public String toString() {
        return "LyricCollection{" +
                "band='" + band + '\'' +
                ", lyrics=" + lyrics +
                '}';
    }
}
