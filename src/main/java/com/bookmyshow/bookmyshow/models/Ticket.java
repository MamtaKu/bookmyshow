package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.LocalTime;
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
    @JsonIgnore
    private List<Payment> payments;

    @ManyToOne
    @JsonIgnore
    private User user;

    @ManyToMany
    private List<ShowSeat> showSeats;
    @JsonIgnore
    private LocalDateTime bookedAt;
    @JsonIgnore
    private double amount;

}
