package org.jesperancinha.std.flash51.stereotypes;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Component;

@Component
public class BlurComponentLife {
    BlurComponentLife() {
        ConsolerizerComposer.out(" ")
                .yellow("There must be more to life")
                .blue("This is Blur")
                .orange("Our annotations are %s", (Object[]) this.getClass().getAnnotations())
                .toConsoleLn();
    }
}
