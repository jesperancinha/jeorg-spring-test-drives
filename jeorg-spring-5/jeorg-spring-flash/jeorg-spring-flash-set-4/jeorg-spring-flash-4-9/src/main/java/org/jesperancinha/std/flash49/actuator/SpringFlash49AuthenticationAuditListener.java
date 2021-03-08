package org.jesperancinha.std.flash49.actuator;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.actuate.security.AbstractAuthenticationAuditListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.stereotype.Component;

@Component
@Profile("prod")
public class SpringFlash49AuthenticationAuditListener extends AbstractAuthenticationAuditListener {

    @Override
    public void onApplicationEvent(AbstractAuthenticationEvent event) {
        ConsolerizerComposer
                .out(" ")
                .brightMagenta("This event has been thrown by the AbstractAuthenticationAuditListener ->")
                .green(event)
                .toConsoleLn();
    }
}
