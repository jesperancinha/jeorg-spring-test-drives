package org.jesperancinha.std.flash.aop;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.BRIGHT_RED;

public class Vase {

    public Plant seed(final Seed seed) {
        BRIGHT_RED.printGenericTitleLn("Seeds %s are in the vase!", seed.getName());
        return new Plant(seed.getName() + " plant");
    }
}
