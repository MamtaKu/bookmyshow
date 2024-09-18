package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.services.MovieService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class TestMovieController {
    @Mock
    private MovieService movieService;

    @InjectMocks
    private MovieController movieController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetMovieById() {

        Movie movie = new Movie();
        movie.setId(1L);
        movie.setName("Movie name");
        when(movieService.getMovieById(1L)).thenReturn(movie);

        Movie result = movieController.getMovieById(1L);

        assertEquals(movie, result);

    }


    @Test
    public void testGetAllMovies() {
        Movie movie1 = new Movie();
        movie1.setId(1L);
        movie1.setName("First Movie name");
        Movie movie2 = new Movie();
        movie1.setId(2L);
        movie1.setName("Second Movie name");
        List<Movie> movies = Arrays.asList(movie1, movie2);
        when(movieService.getAllMovie()).thenReturn(movies);

        List<Movie> result = movieController.getAllMovie();

        assertEquals(movies, result);

    }

}
