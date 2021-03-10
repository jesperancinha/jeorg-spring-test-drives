package org.jesperancinha.std.flash418.controller.advice;

import java.time.LocalDate;

public class Song {

    private String name;

    private String artist;

    private LocalDate hitDate;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public LocalDate getHitDate() {
        return hitDate;
    }

    public void setHitDate(LocalDate hitDate) {
        this.hitDate = hitDate;
    }

    @Override
    public String toString() {
        return "Song{" +
                "name='" + name + '\'' +
                ", artist='" + artist + '\'' +
                ", hitDate=" + hitDate +
                '}';
    }
}
