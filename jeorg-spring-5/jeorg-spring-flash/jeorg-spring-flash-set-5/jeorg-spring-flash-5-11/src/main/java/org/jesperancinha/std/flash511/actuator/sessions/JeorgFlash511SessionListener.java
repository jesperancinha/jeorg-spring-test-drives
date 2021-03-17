package org.jesperancinha.std.flash511.actuator.sessions;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

@Component
public class JeorgFlash511SessionListener implements HttpSessionListener {

    private final SessionService sessionService;

    public JeorgFlash511SessionListener(SessionService sessionService) {
        this.sessionService = sessionService;
    }

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        sessionService.addSession(se.getSession());
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        sessionService.removeSession(se.getSession());
    }
}