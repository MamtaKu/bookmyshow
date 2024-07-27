package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.Feature;
import com.bookmyshow.bookmyshow.models.Seat;
import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.models.Theatre;
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
public class ScreenRequestDto {
    private String name;

    private List<Feature> features;

    private Theatre theatre;
}
