package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends Basemodel {

    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    private List<Theatre> theatres;



}
