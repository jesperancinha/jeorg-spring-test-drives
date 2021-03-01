package org.jesperancinha.std.flash216.platformtransactionmanagement.domain;

import java.time.LocalDateTime;

public class Award {
    private String artist;

    private String award;

    private LocalDateTime awardDate;

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public LocalDateTime getAwardDate() {
        return awardDate;
    }

    public void setAwardDate(LocalDateTime awardDate) {
        this.awardDate = awardDate;
    }

    @Override
    public String toString() {
        return "Award{" +
                "artist='" + artist + '\'' +
                ", award='" + award + '\'' +
                ", awardDate=" + awardDate +
                '}';
    }
}
