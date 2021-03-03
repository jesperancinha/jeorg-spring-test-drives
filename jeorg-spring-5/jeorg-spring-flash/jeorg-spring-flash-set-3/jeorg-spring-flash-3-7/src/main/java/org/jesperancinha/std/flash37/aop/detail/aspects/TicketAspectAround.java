package org.jesperancinha.std.flash37.aop.detail.aspects;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.jesperancinha.std.flash37.aop.detail.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.jesperancinha.console.consolerizer.ConsolerizerColor.YELLOW;

@Aspect
@Component
public class TicketAspectAround {
    @Around("execution(* org.jesperancinha.std.flash37.aop.detail.service.TicketServiceImpl.createTicket(..))")
    public Object aroundTicket(ProceedingJoinPoint pjp) {
        YELLOW.printGenericLn("Around -> TicketService.createTicket() -> %s", pjp.getSignature().getName());
        final Ticket ticket = (Ticket) pjp.getArgs()[0];
        ticket.setUuid(UUID.randomUUID());
        return ticket;
    }
}
