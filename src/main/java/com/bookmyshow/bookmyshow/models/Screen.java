package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Screen extends Basemodel {
    private String name;

    @OneToMany(mappedBy = "screen")
    @JsonManagedReference
    @JsonIgnore
    private List<Seat> seats;

    @OneToMany(mappedBy = "screen")
//    @JsonManagedReference
    @JsonIgnoreProperties("screen")
    @JsonIgnore
    private List<Show> shows;

    @Enumerated(EnumType.ORDINAL)
    @ElementCollection
    @JsonIgnore
    private List<Feature> features;


    @ManyToOne
    @JoinColumn(name = "theatre_id")
    @JsonBackReference
    private Theatre theatre;
}
