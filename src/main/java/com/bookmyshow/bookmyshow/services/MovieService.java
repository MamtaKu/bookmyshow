package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.MovieRequestDto;
import com.bookmyshow.bookmyshow.models.Movie;

import java.util.List;

public interface MovieService {
    Movie getMovieById(Long id);
    List<Movie> getAllMovie();

    List<Movie> getMoviesByCityAndTheatre(String city, String theatre);

    Movie createMovie(MovieRequestDto movie);

    void deleteMovie(Long id);
    Movie updateMovie(Long id, MovieRequestDto movieRequestDto);

    Movie patchMovie(Long id, MovieRequestDto movieRequestDto);

    Movie findByName(String name);
}
