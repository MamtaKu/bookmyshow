package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.SeatType;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SeatRequestDto {

    private int rowval;
    private int colval;
    private String seatNumber;

    private SeatType seatType;

    private String screen;
    
}
