package org.jesperancinha.std.mastery1.french.music.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import java.time.LocalDate;
import java.util.List;

@Table
@Entity
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private LocalDate publicationDate;

    @OneToOne
    private Label label;

    @OneToOne
    private Artist artist;

    @OneToMany
    private List<Song> songList;
}
