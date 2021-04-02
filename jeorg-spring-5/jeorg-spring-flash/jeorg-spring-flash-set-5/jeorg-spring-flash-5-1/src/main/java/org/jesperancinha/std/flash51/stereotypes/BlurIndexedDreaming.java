package org.jesperancinha.std.flash51.stereotypes;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Indexed;

@Indexed
public class BlurIndexedDreaming {
    BlurIndexedDreaming() {
        ConsolerizerComposer.out(" ")
                .yellow("And then you start dreaming")
                .blue("This is Blur")
                .orange("Our annotations are %s", (Object[]) this.getClass().getAnnotations())
                .toConsoleLn();
    }
}
