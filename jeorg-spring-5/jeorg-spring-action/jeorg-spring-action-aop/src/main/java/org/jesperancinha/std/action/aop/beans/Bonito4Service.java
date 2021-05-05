package org.jesperancinha.std.action.aop.beans;

import org.aspectj.lang.JoinPoint;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Service;

@Service
public class Bonito4Service {

    public void waitPrivatelyForFishCatch(JoinPoint joinPoint) {
    }

    public void waitForFishCatch(JoinPoint joinPoint) {
        ConsolerizerComposer.outSpace()
                .bgBlue()
                .unicorns(100)
                .reset()
                .blue("Waiting for fish...");
    }

    public void beforeAnyCatch(JoinPoint joinPoint) {

    }
}
