package com.bookmyshow.bookmyshow.dtos;

import com.bookmyshow.bookmyshow.models.Feature;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Getter
@Setter
public class ShowRequestDto {
    private Long movieId;
    private Long screenId;
    private Long theatreId;

   // private String movie;

    private LocalDateTime startTime;

    private LocalDateTime endTime;

  //  private String screen;

    private List<Feature> features;

  //  private String theatre;
}
