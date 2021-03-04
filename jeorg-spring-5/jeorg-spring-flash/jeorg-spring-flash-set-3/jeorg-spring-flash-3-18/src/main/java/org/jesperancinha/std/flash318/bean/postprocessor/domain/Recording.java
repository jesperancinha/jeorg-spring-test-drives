package org.jesperancinha.std.flash318.bean.postprocessor.domain;

import java.time.LocalDateTime;

public class Recording {
    private String title;

    private Long years;

    private String studio;

    private String address;

    public Recording() {
    }

    public Recording(String title, Long years, String studio,
                     String address) {
        this.title = title;
        this.studio = studio;
        this.address = address;
        this.years= years;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Long getYears() {
        return years;
    }

    public void setYears(Long years) {
        this.years = years;
    }

    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Recording{" +
                "title='" + title + '\'' +
                ", years=" + years +
                ", studio='" + studio + '\'' +
                ", address='" + address + '\'' +
                '}';
    }
}
