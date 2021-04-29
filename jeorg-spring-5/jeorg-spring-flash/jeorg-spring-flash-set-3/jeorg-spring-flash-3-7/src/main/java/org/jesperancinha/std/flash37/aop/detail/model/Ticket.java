package org.jesperancinha.std.flash37.aop.detail.model;

import lombok.Builder;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;
import java.util.UUID;

@Table
@Entity
@Data
@Builder
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String artist;

    @Column
    private String show;

    @Column
    private LocalDateTime localDateTime;

    @Column
    private UUID uuid;
}
