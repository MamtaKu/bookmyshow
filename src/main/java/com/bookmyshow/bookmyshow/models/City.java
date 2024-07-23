package com.bookmyshow.bookmyshow.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table( uniqueConstraints = @UniqueConstraint(columnNames = "name"))
public class City extends Basemodel {

    @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "city")
    @JsonManagedReference
    @JsonIgnore
    private List<Theatre> theatres;



}
