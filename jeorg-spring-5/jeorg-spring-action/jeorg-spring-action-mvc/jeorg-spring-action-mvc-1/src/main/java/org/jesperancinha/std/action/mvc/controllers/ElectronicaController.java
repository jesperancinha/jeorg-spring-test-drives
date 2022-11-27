package org.jesperancinha.std.action.mvc.controllers;

import jakarta.servlet.ServletRequest;
import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.jesperancinha.std.action.mvc.dto.Capacitors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;
import java.util.List;

import static org.jesperancinha.console.consolerizer.console.ConsolerizerComposer.title;
import static org.jesperancinha.std.action.mvc.dto.CapacitorType.CERAMIC;
import static org.jesperancinha.std.action.mvc.dto.CapacitorType.MICA;
import static org.jesperancinha.std.action.mvc.dto.CapacitorType.NON_POLARIZED;
import static org.jesperancinha.std.action.mvc.dto.CapacitorUnit.uF;

@RestController
@RequestMapping("api")
public class ElectronicaController {

    @GetMapping("{reference}")
    public List<Capacitors> getCapacitorBatches(
            @PathVariable
                    String reference,
            ServletRequest servletRequest,
            @RequestParam
                    String extra,
            Principal principal) {
        ConsolerizerComposer.outSpace()
                .cyan(title("These are some of the inputs we can get from our REST requests"))
                .red("This is a reference from @PathVariable %s", reference)
                .yellow("This is a servletRequest from ServletRequest %s", servletRequest)
                .blue("This is an extra from @RequestParam %s", extra)
                .green("Finally this is a principal from Principal %s", principal)
                .reset();

        return List.of(
                new Capacitors(100L, "REFERENCE123", CERAMIC, 100L, uF),
                new Capacitors(150L, "REFERENCE456", MICA, 200L, uF),
                new Capacitors(200L, "REFERENCE789", NON_POLARIZED, 200L, uF)
        );

    }
}
