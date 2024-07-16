package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);
    List<Movie> getAllMovie();

    List<Movie> getMoviesByCityAndTheatre(String city, String theatre);
}
