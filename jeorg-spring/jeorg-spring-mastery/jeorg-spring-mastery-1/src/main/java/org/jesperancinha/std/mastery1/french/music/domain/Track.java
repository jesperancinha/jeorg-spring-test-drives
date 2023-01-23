package org.jesperancinha.std.mastery1.french.music.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Track {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long trackNumber;

    @OneToOne
    private Song song;

    @OneToOne
    private Record record;

}
