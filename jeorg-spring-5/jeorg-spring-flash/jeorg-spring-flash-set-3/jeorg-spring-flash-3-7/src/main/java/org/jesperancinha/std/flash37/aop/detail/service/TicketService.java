package org.jesperancinha.std.flash37.aop.detail.service;

import org.jesperancinha.std.flash37.aop.detail.model.Ticket;

public interface TicketService {
    Ticket createTicket(final Ticket ticket);

    Ticket createTicketNoAround(Ticket ticket);
}
