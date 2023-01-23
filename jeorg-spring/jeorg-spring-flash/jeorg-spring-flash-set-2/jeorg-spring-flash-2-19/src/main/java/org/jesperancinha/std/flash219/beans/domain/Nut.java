package org.jesperancinha.std.flash219.beans.domain;

import lombok.Data;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.BROWN;
import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.ORANGE;

@Data
public class Nut {

    private String name;

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
