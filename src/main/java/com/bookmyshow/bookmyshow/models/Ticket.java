package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.BookingStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
public class Ticket extends Basemodel {


    @Enumerated(EnumType.ORDINAL)
    private BookingStatus bookingStatus;

    @ManyToOne
    private Show show;

    @OneToMany
    private List<City.Payment> payments;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<Movie.ShowSeat> showSeats;
    private LocalDateTime bookedAt;
    private double amount;

}
