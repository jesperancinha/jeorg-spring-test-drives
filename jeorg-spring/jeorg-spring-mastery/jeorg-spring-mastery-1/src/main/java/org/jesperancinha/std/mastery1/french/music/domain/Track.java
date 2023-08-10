package org.jesperancinha.std.mastery1.french.music.domain;

import jakarta.persistence.*;

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
