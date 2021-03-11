package org.jesperancinha.std.flash51.stereotypes;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Service;

@Service
public class BlurServiceBnB {
    BlurServiceBnB() {
        ConsolerizerComposer.out(" ")
                .yellow("Runs a little BnB")
                .blue("This is Blur")
                .orange("Our annotations are %s", (Object[]) this.getClass().getAnnotations())
                .toConsoleLn();

    }
}
