package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Seat extends Basemodel {
    private int rowval;
    private int colval;
    private String seatNumber;
    @Enumerated(EnumType.ORDINAL)
    private SeatType seatType;
    @ManyToOne
    @JoinColumn(name="screen_id")
    private Screen screen;
}
