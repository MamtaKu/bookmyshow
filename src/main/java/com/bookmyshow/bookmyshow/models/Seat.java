package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends Basemodel {
    private int rowval;
    private int colval;
    private String seatNumber;
    @ManyToOne
    private SeatType seatType;
}
