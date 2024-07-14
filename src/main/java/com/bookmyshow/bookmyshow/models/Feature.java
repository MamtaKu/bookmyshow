package com.bookmyshow.bookmyshow.models;

import com.bookmyshow.bookmyshow.enums.FeatureEnum;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Feature extends Basemodel{


    @Enumerated(EnumType.ORDINAL)
    private FeatureEnum type;

    @ManyToMany(mappedBy = "features")
    private List<Screen> screens;

    // Getters and Setters
}
