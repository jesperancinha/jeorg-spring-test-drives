package org.jesperancinha.std.app1.jdbc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity
public class Boat extends CruiseBase {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}