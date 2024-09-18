package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.*;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
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

//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime startTime;
//    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private LocalDateTime endTime;

//    @OneToMany
//    private List<ShowSeat> showSeats;

    @ManyToOne
    @JoinColumn(name = "screen_id")
    @JsonIgnoreProperties("shows")
    private Screen screen;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    @JsonIgnore
    private List<Feature> features;

    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonBackReference
    private Theatre theatre;
}
