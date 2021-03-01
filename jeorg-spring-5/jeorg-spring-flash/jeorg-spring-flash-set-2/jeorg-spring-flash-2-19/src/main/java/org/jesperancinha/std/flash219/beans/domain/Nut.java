package org.jesperancinha.std.flash219.beans.domain;

import org.jesperancinha.console.consolerizer.ConsolerizerColor;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BROWN;
import static org.jesperancinha.console.consolerizer.ConsolerizerColor.ORANGE;

public class Nut {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void goToCake() {
        BROWN.printGenericLn("Going to cake...");
    }

    @Override
    public String toString() {
        return "Nut{" +
                "name='" + name + '\'' +
                '}';
    }

    private void initiate() {
        ORANGE.printGenericLn("Creating %s", toString());
    }
}
