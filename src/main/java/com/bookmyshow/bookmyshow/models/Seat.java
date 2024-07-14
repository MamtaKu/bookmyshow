package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.SeatType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
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
}
