package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.services.MovieService;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping
    public List<Movie> getAllMovie(){
        return movieService.getAllMovie();

    }

    @GetMapping("/byCityAndTheatre")
    public List<Movie> getMoviesByCityAndTheatre(@RequestParam  String city, @RequestParam String theatre){
        return movieService.getMoviesByCityAndTheatre(city, theatre);
    }



}
