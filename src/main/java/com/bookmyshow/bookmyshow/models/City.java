package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
public class City extends Basemodel {

    private String name;

    @OneToMany(mappedBy = "city", fetch = FetchType.EAGER)
    @JsonManagedReference
    private List<Theatre> theatres;



}
