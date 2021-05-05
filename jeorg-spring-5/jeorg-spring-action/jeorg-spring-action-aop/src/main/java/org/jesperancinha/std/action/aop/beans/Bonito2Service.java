package org.jesperancinha.std.action.aop.beans;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Service;

@Service
public class Bonito2Service {

    public void waitPrivatelyForFishCatch() {
    }

    public void waitForFishCatch() {
        ConsolerizerComposer.outSpace()
                .bgBlue()
                .unicorns(100)
                .reset()
                .blue("Waiting for fish...");
    }
}
