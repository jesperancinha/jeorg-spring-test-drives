package org.jesperancinha.std.mastery1.french.music.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table
public class Song {

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    private Long trackNumber;

    private String name;

    private String shortLyric;

    @OneToOne
    private Artist artist;

    private LocalDate recordingDate;

    @OneToMany
    private List<Record> records;
}
