package org.jesperancinha.std.flash310.jsoncomponent.controller;

import org.jesperancinha.console.consolerizer.common.ConsolerizerColor;
import org.jesperancinha.std.flash310.jsoncomponent.dto.Guitar;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.MAGENTA;

@RestController
public class GuitarController {


    @GetMapping(path = "/")
    public List<Guitar> allGuitars() {
        return Arrays.asList(
                new Guitar("Fender", "75TH Anni Com Strat MN 2BB", 2400L, "EUR"),
                new Guitar("Jackson", "Jackson JS Series Dinky JS32Q DKA Trans Purple Burst", 500L, "EUR")
        );
    }

    @PostMapping(path = "/")
    public void createGuitar(@RequestBody final Guitar guitar) {
        MAGENTA.printGenericLn("You've created guitar -> %s", guitar);
    }
}
