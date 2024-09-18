package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.CreateTicketRequestDTO;
import com.bookmyshow.bookmyshow.dtos.CreateTicketResponseDTO;
import com.bookmyshow.bookmyshow.exceptions.ShowSeatNotAvaialbleException;
import com.bookmyshow.bookmyshow.models.*;
import com.bookmyshow.bookmyshow.repositories.ShowRepository;
import com.bookmyshow.bookmyshow.repositories.ShowSeatRepository;
import com.bookmyshow.bookmyshow.repositories.TicketRepository;
import com.bookmyshow.bookmyshow.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class TicketServiceImpl implements TicketService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ShowRepository showRepository;
    @Autowired
    private ShowSeatRepository showSeatRepository;
    @Autowired
    private TicketRepository ticketRepository;

    @Override
    //No parallal transaction
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public Ticket bookTicket(Long userId, List<Long> showSeatIds, Long showId) {
        //Get the user
        User bookedByUser =  userRepository.findById(userId).get();
        //Get the show
        Show show = showRepository.findById(showId).get();


        List<ShowSeat> showSeats = new ArrayList<>();
        for(Long showSeatId : showSeatIds){
            //Get the showseat
            ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
            //check the show seat availability
            if(showSeat.getShowSeatStatus().equals(ShowSeatStatus.AVAILABLE)){
                //If yes, lock the seat
                showSeat.setShowSeatStatus(ShowSeatStatus.LOCKED);
            }
            //If seat is not available
            else{
                throw new ShowSeatNotAvaialbleException("Show seat is not available");
            }

            //save the changes in the db
            showSeatRepository.save(showSeat);
            showSeats.add(showSeat);

        }





        //return the ticket
        Ticket ticket = new Ticket();
        ticket.setUser(bookedByUser);
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setBookedAt(LocalDateTime.now());
        ticket.setBookingStatus(BookingStatus.CONFIRMED);
        ticketRepository.save(ticket);

        return ticket;
    }







    private boolean calculatePrice(){
        return true;
    }
}
