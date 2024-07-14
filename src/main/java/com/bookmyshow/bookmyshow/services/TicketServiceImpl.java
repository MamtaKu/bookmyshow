package com.bookmyshow.bookmyshow.services;

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
        }


        boolean paymentDone = calculatePrice();
        List<ShowSeat> showSeats = new ArrayList<>();

        double amount = 0;


        if(paymentDone){
            for(Long showSeatId : showSeatIds){
                ShowSeat showSeat = showSeatRepository.findById(showSeatId).get();
                showSeat.setShowSeatStatus(ShowSeatStatus.BOOKED);
                showSeatRepository.save(showSeat);
                showSeats.add(showSeat);
                amount = amount + showSeat.getPrice();
            }

        }

        //return the ticket
        Ticket ticket = new Ticket();
        ticket.setUser(bookedByUser);
        ticket.setShow(show);
        ticket.setShowSeats(showSeats);
        ticket.setAmount(amount);
        ticket.setBookedAt(LocalDateTime.now());
        ticket.setBookingStatus(BookingStatus.CONFIRMED);
        ticketRepository.save(ticket);

        return ticket;
    }

    @Override
    public Ticket cancelTicket(Long ticketId) {
        return null;
    }

    private boolean calculatePrice(){
        return true;
    }
}
