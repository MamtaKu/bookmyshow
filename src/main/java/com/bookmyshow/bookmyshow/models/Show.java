package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.FeatureEnum;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter
@Setter
@Entity(name ="shows")
public class Show extends Basemodel {

    @ManyToOne
    private Movie movie;

    private Date startTime;
    private Date endTime;

//    @OneToMany
//    private List<ShowSeat> showSeats;

    @ManyToOne
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<FeatureEnum> featureEnums;
}
