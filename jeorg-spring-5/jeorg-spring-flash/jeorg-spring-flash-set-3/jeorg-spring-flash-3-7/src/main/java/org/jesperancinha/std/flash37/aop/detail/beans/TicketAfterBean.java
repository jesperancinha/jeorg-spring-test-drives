package org.jesperancinha.std.flash37.aop.detail.beans;

import org.aspectj.lang.JoinPoint;
import org.springframework.stereotype.Component;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Component
public class TicketAfterBean {
    public void logBeforeTicket(JoinPoint joinPoint) {
        YELLOW.printGenericLn("After -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
    }

    public void logBeforeTicketNoAround(JoinPoint joinPoint) {
        YELLOW.printGenericLn("After -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
    }
}
