package com.steelzack.b2b2springboot.entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * Created by joao on 24-5-16.
 */

@Getter
@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SpaceRocket {

    @Id
    private Integer id;

    private String name;

    // In meters
    private double height;

    private String engineType;

    // In Kg
    private double payLoad;

}
