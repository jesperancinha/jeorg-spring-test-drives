package org.jesperancinha.std.flash37.aop.detail.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.jesperancinha.std.flash37.aop.detail.model.Ticket;
import org.springframework.stereotype.Component;

import java.util.UUID;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Aspect
@Component
public class TicketAspectBefore {
    @Before("execution(* org.jesperancinha.std.flash37.aop.detail.service.TicketServiceImpl.createTicket*(..))")
    public void logBeforeTicket(JoinPoint joinPoint) {
        YELLOW.printGenericLn("Before -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
    }


    @Before("execution(* org.jesperancinha.std.flash37.aop.detail.service.TicketServiceImpl.createTicketNoAround*(..))")
    public void logBeforeTicketNoAround(JoinPoint joinPoint) {
        YELLOW.printGenericLn("After -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
        final Ticket ticket = (Ticket) joinPoint.getArgs()[0];
        ticket.setUuid(UUID.randomUUID());
    }
}
