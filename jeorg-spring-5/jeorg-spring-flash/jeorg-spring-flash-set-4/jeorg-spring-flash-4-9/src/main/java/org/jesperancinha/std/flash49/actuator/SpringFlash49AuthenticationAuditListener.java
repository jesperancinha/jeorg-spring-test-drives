package org.jesperancinha.std.flash49.actuator;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.security.AbstractAuthenticationAuditListener;
import org.springframework.context.annotation.Profile;
import org.springframework.security.authentication.event.AbstractAuthenticationEvent;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotNull;
import java.util.Objects;
import java.util.Optional;

@Component
@Profile("prod")
public class SpringFlash49AuthenticationAuditListener extends AbstractAuthenticationAuditListener {

    private final AuditEventRepository auditEventRepository;

    public SpringFlash49AuthenticationAuditListener(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Override
    public void onApplicationEvent(final @NotNull
                                           AbstractAuthenticationEvent event) {
        ConsolerizerComposer
                .out(" ")
                .brightMagenta("This event has been thrown by the AbstractAuthenticationAuditListener ->")
                .green(event)
                .toConsoleLn();
        final Authentication authentication = event.getAuthentication();
        final Object source = event.getSource();
        final long timestamp = event.getTimestamp();

        var principal = (Object) null;
        if (Objects.nonNull(authentication)) {
            principal = authentication.getPrincipal();
        }
        final var auditEvent = new AuditEvent(
                Optional.ofNullable(principal).orElse("").toString(),
                source.toString(),
                String.valueOf(timestamp));
        auditEventRepository.add(auditEvent);
    }
}
