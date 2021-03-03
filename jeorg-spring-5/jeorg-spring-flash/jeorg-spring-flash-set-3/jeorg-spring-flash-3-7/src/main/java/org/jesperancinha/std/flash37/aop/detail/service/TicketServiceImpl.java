package org.jesperancinha.std.flash37.aop.detail.service;

import org.jesperancinha.std.flash37.aop.detail.model.Ticket;
import org.jesperancinha.std.flash37.aop.detail.repository.TicketRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @Override
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket createTicket(Ticket ticket) {
        return ticketRepository.save(ticket);
    }

    @Override
    public Ticket createTicketNoAround(Ticket ticket) {
        return ticketRepository.save(ticket);
    }
}
