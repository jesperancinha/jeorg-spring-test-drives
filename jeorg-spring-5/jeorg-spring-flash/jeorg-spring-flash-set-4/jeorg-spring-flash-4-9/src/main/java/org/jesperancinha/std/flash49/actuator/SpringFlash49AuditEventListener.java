package org.jesperancinha.std.flash49.actuator;

import org.jesperancinha.console.consolerizer.console.ConsolerizerComposer;
import org.springframework.boot.actuate.audit.AuditEvent;
import org.springframework.boot.actuate.audit.AuditEventRepository;
import org.springframework.boot.actuate.audit.listener.AbstractAuditListener;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component
@Profile("!prod")
public class SpringFlash49AuditEventListener extends AbstractAuditListener {

    private final AuditEventRepository auditEventRepository;

    public SpringFlash49AuditEventListener(AuditEventRepository auditEventRepository) {
        this.auditEventRepository = auditEventRepository;
    }

    @Override
    protected void onAuditEvent(final AuditEvent event) {
        ConsolerizerComposer
                .out(" ")
                .brightMagenta("This event has been thrown by the AbstractAuditListener ->")
                .green(event)
                .toConsoleLn();
        auditEventRepository.add(event);
    }
}

