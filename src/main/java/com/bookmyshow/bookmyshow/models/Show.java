package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Movie movie;

    private Date startTime;
    private Date endTime;

//    @OneToMany
//    private List<ShowSeat> showSeats;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonBackReference
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    private List<Feature> features;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonBackReference
    private Theatre theatre;
}
