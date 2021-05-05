package org.jesperancinha.std.flash516.shutdown.controller;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;

import javax.annotation.PreDestroy;

@Component
public class SkynetNetwork {
    @PreDestroy
    public void preDestroy() {
        ConsolerizerComposer
                .outSpace()
                .cyan("Yeeehhaaaaa!!!")
                .reset();
    }
}
