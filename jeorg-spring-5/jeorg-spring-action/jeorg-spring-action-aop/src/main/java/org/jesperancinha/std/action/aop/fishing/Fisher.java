package org.jesperancinha.std.action.aop.fishing;

import org.jesperancinha.std.action.aop.model.Cod;
import org.jesperancinha.std.action.aop.model.SeaFood;

public class Fisher implements Harvester {

    public SeaFood harvest() {
        return new Cod();
    }

    public void justFishAnything() {

    }
}
