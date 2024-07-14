package com.bookmyshow.bookmyshow.models;

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
    List<Feature> features;


}
