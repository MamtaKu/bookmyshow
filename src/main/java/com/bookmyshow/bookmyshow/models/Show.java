package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    @JoinColumn(name = "movie_id")
    @JsonManagedReference
    private Movie movie;

    private Date startTime;
    private Date endTime;

//    @OneToMany
//    private List<ShowSeat> showSeats;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;
}
