package com.bookmyshow.bookmyshow.models;

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
    @Column(nullable = false, unique = true)
    private String name;
    @OneToMany()
    private List<Theatre> theatres;



}
