package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
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
    private List<Payment> payments;

    @ManyToOne
    private User user;

    @ManyToMany
    private List<ShowSeat> showSeats;
    private Date bookedAt;
    private  int amount;

}
