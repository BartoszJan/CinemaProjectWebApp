package com.bjanczak.service.interfaces;


import com.bjanczak.model.Ticket;

import java.util.List;

public interface TicketService {

    void addTicket(Ticket ticket);

    Ticket getTicket(int ticketId);

    List<Ticket> getTickets();

    void deleteTicket(Ticket ticket);
}
