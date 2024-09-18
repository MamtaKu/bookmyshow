package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.CreateTicketRequestDTO;
import com.bookmyshow.bookmyshow.dtos.CreateTicketResponseDTO;
import com.bookmyshow.bookmyshow.models.BookingStatus;
import com.bookmyshow.bookmyshow.models.Ticket;
import com.bookmyshow.bookmyshow.services.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tickets")
public class TicketController {

     @Autowired
     private TicketService ticketService;
     @PostMapping()
     public ResponseEntity<Ticket> bookTicket(@RequestBody CreateTicketRequestDTO createTicketRequestDTO){
          Ticket ticket = ticketService.bookTicket(createTicketRequestDTO.getUserId(),
                  createTicketRequestDTO.getShowSeatIds(),
                  createTicketRequestDTO.getShowId());
          return new ResponseEntity<>(ticket, HttpStatus.CREATED);
     }
//     public CreateTicketResponseDTO bookTicket(
//             CreateTicketRequestDTO createTicketRequestDTO){
//
//          CreateTicketResponseDTO createTicketResponseDTO = new CreateTicketResponseDTO();
//
//          Ticket ticket = ticketService.bookTicket(
//                  createTicketRequestDTO.getUserId(),
//                  createTicketRequestDTO.getShowSeatIds(),
//                  createTicketRequestDTO.getShowId());
//
//          createTicketResponseDTO.setTicketId(ticket.getId());
//          createTicketResponseDTO.setBookingStatus(BookingStatus.CONFIRMED);
//
//          return createTicketResponseDTO;
//
//     }
}
