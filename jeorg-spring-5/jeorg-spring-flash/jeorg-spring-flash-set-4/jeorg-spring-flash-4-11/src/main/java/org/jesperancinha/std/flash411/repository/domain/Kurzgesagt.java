package org.jesperancinha.std.flash411.repository.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDate;

@Entity
@Table
public class Kurzgesagt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String episode;

    @Column
    private LocalDate youTubePublication;

    @Column
    private String youtubeCode;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEpisode() {
        return episode;
    }

    public void setEpisode(String episode) {
        this.episode = episode;
    }

    public LocalDate getYouTubePublication() {
        return youTubePublication;
    }

    public void setYouTubePublication(LocalDate youTubePublication) {
        this.youTubePublication = youTubePublication;
    }

    public String getYoutubeCode() {
        return youtubeCode;
    }

    public void setYoutubeCode(String youtubeCode) {
        this.youtubeCode = youtubeCode;
    }
}
