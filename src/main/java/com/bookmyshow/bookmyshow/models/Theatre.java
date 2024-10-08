package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
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
    @JoinColumn(name = "city_id")
    @JsonBackReference
    private City city;

//

    @OneToMany(mappedBy = "theatre")
    @JsonManagedReference
    @JsonIgnore
    private List<Screen> screens;
}



