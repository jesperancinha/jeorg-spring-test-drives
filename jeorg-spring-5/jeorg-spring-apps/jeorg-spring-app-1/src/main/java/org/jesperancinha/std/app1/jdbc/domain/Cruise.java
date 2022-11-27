package org.jesperancinha.std.app1.jdbc.domain;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Table
@Entity
public class Cruise extends CruiseBase {

    private String name;

    private Boat boat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boat getBoat() {
        return boat;
    }

    public void setBoat(Boat boat) {
        this.boat = boat;
    }
}
