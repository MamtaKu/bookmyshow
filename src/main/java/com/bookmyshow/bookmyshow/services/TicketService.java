package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.CreateTicketRequestDTO;
import com.bookmyshow.bookmyshow.dtos.CreateTicketResponseDTO;
import com.bookmyshow.bookmyshow.models.ShowSeat;
import com.bookmyshow.bookmyshow.models.Ticket;

import java.util.List;

public interface TicketService {
    Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId);


}
