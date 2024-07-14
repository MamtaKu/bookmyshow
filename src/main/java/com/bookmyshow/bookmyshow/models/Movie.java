package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.FeatureEnum;
import com.bookmyshow.bookmyshow.enums.ShowSeatStatus;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Movie extends Basemodel {
    @Column(unique = true)
    private String name;
    private String description;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    List<FeatureEnum> featureEnums;


    @Getter
    @Setter
    @Entity
    public static class ShowSeat extends Basemodel {
        @ManyToOne
        private Show show;

        @Enumerated(EnumType.ORDINAL)
        private ShowSeatStatus showSeatStatus;

        @ManyToOne
        private Seat seat;
        private double price;


    }
}
