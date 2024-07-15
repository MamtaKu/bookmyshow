package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.services.MovieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/movie")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping("/{id}")
    public Movie getMovieById(@PathVariable("id") Long id){
        return movieService.getMovieById(id);

    }

    @GetMapping()
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();

    }



}
