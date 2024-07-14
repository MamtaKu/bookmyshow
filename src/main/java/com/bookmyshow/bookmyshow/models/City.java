package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.PaymentStatus;
import com.bookmyshow.bookmyshow.enums.PaymentType;
import com.bookmyshow.bookmyshow.enums.SeatType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends Basemodel {
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany()
    private List<Theatre> theatres;


    @Getter
    @Setter
    @Entity
    public static class Payment extends Basemodel {
        private int refNo;
        private int amount;

        @Enumerated(EnumType.ORDINAL)
        private PaymentStatus paymentStatus;

        @Enumerated(EnumType.ORDINAL)
        private PaymentType paymentType;
    }

    @Getter
    @Setter
    @Entity
    public static class ShowSeatType extends Basemodel {
        @ManyToOne
        private Show show;
        @Enumerated(EnumType.ORDINAL)
        private SeatType seatType;
        private int price;
    }
}
