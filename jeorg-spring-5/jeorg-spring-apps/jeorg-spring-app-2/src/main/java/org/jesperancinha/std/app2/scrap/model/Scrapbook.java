package org.jesperancinha.std.app2.scrap.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import static javax.persistence.GenerationType.AUTO;

@Entity
@Table
public class Scrapbook {

    @Id
    @GeneratedValue(strategy = AUTO)
    private Long id;

    private String name;

    private Integer pages;

}
