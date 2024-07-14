package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);

    Ticket cancelTicket(Long ticketId);
}
