package org.jesperancinha.std.flash37.aop.detail.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import static org.jesperancinha.console.consolerizer.common.ConsolerizerColor.YELLOW;

@Aspect
@Component
public class TicketAspectAfter {
    @After("execution(* org.jesperancinha.std.flash37.aop.detail.service.TicketServiceImpl.createTicket*(..))")
    public void logBeforeTicket(JoinPoint joinPoint) {
        YELLOW.printGenericLn("After -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
    }

    @After("execution(* org.jesperancinha.std.flash37.aop.detail.service.TicketServiceImpl.createTicketNoAround*(..))")
    public void logBeforeTicketNoAround(JoinPoint joinPoint) {
        YELLOW.printGenericLn("After -> TicketService.createTicket() -> %s", joinPoint.getSignature().getName());
    }
}
