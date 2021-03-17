package org.jesperancinha.std.flash511.actuator.sessions;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JeorgFlash511SessionController {

    private final SessionService sessionService;

    public JeorgFlash511SessionController(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @GetMapping(path = "actuator/sessions",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public JeorgFlash511SessionActuatorData listActiveSessions() {
        return new JeorgFlash511SessionActuatorData("Active Sessions", sessionService.getSessions());
    }

}