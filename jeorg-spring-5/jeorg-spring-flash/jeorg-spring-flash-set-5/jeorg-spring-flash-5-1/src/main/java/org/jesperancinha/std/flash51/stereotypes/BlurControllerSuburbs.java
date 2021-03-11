package org.jesperancinha.std.flash51.stereotypes;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/")
public class BlurControllerSuburbs {
    BlurControllerSuburbs() {
        ConsolerizerComposer.out(" ")
                .yellow("She's been feeling frisky since her husband said goodbye")
                .blue("This is Blur")
                .orange("Our annotations are %s", (Object[]) this.getClass().getAnnotations())
                .toConsoleLn();
    }

    @GetMapping("/")
    public ResponseEntity<String> blur() {
        return ResponseEntity.ok().build();
    }

}
