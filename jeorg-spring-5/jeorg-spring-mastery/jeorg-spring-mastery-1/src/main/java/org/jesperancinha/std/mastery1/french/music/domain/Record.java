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
