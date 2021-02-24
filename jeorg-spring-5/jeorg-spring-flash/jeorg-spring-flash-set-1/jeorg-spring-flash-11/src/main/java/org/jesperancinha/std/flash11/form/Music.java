package org.jesperancinha.std.flash11.form;

public class Music {

    private String artist;
    private String song;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getSong() {
        return song;
    }

    public void setSong(String song) {
        this.song = song;
    }

    @Override
    public String toString() {
        return "Music{" +
                "artist='" + artist + '\'' +
                ", song='" + song + '\'' +
                '}';
    }
}
