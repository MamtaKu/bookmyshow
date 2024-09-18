package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class ShowSeat extends Basemodel {
    @ManyToOne
    @JsonIgnore
    private Show show;

    @Enumerated(EnumType.ORDINAL)
    @JsonIgnore
    private ShowSeatStatus showSeatStatus;

    @ManyToOne
    private Seat seat;
    @JsonIgnore
    private double price;

/*    1                1
   ShowSeat ---------Show
     M                1
   Show - X
   Seat - A1,B1,C1


   ShowSeat ---XA1,XB1....


    1                1
   ShowSeat ------- Seat
       M               1
  XA1
  XB1
  YA1
  YB1

 */
}
