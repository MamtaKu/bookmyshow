package com.bookmyshow.bookmyshow.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class Theatre extends Basemodel {
    @Column(unique = true)
    private String name;

    @ManyToOne
    private City city;

    @OneToMany(mappedBy = "theatre")
    private List<Screen> screens;
}



