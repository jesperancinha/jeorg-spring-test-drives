package org.jesperancinha.std.flash51.stereotypes;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.stereotype.Repository;

@Repository
public class BlurRepositoryStereotypes {
    public BlurRepositoryStereotypes(){
        ConsolerizerComposer.out(" ")
                .yellow("Than stereotypes")
                .blue("This is Blur")
                .orange("Our annotations are %s", (Object[]) this.getClass().getAnnotations())
                .toConsoleLn();
    }
}
