package org.jesperancinha.std.flash37.aop.detail.controller;

import org.jesperancinha.console.consolerizer.Consolerizer;
import org.jesperancinha.std.flash37.aop.detail.model.Ticket;
import org.jesperancinha.std.flash37.aop.detail.service.TicketService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }


    @PostMapping("/")
    public UUID createTicket(@RequestBody final Ticket ticket){
        final Ticket ticket1 = ticketService.createTicket(ticket);
        Consolerizer.printRainbowTitleLn("Created ticket %s", ticket1);
        return ticket1.getUuid();
    }

    @PostMapping("/no-around")
    public UUID createTicketNoAround(@RequestBody final Ticket ticket){
        final Ticket ticket1 = ticketService.createTicketNoAround(ticket);
        Consolerizer.printRainbowTitleLn("Created ticket %s", ticket1);
        return ticket1.getUuid();
    }
}
