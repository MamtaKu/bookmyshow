package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.Feature;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieRequestDto {
    private long id;
    private String name;
    private List<Feature> features;
    private String description;
}
