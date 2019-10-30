package com.steelzack.b2b2java8.caching;

import lombok.Getter;

import java.io.Serializable;

/**
 * Created by joaofilipesabinoesperancinha on 02-05-16.
 */
@Getter
public class Album implements Serializable {
    private String band;
    private String music;
    private int year;
    private static final long serialVersionUID = 1L;


    public Album(String band, String music, int year) {
        this.band = band;
        this.music = music;
        this.year = year;
    }

    @Override
    public String toString() {
        return String.format("Band->%s Music->%s Year->%s", this.band, this.music, this.year);
    }
}
