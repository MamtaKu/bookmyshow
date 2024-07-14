package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.CreateTicketRequestDTO;
import com.bookmyshow.bookmyshow.dtos.CreateTicketResponseDTO;
import com.bookmyshow.bookmyshow.enums.BookingStatus;
import com.bookmyshow.bookmyshow.models.Ticket;
import com.bookmyshow.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TicketController {

     @Autowired
     private TicketService ticketService;
     @PostMapping()
     public CreateTicketResponseDTO bookTicket(
             CreateTicketRequestDTO createTicketRequestDTO){

          CreateTicketResponseDTO createTicketResponseDTO = new CreateTicketResponseDTO();

          Ticket ticket = ticketService.bookTicket(
                  createTicketRequestDTO.getUserId(),
                  createTicketRequestDTO.getShowSeatIds(),
                  createTicketRequestDTO.getShowId());

          createTicketResponseDTO.setTicketId(ticket.getId());
          createTicketResponseDTO.setBookingStatus(BookingStatus.CONFIRMED);

          return createTicketResponseDTO;

     }
}
