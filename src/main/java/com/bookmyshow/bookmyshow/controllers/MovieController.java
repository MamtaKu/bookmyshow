package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.MovieRequestDto;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.services.MovieService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
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

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Movie> createMovie(@RequestBody MovieRequestDto movie){
        Movie createdMovie = movieService.createMovie(movie);
        return new ResponseEntity<>(createdMovie, HttpStatus.CREATED);
    }



    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteMovie(@PathVariable Long id){
        movieService.deleteMovie(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Movie> updateMovie(@PathVariable Long id, @RequestBody MovieRequestDto movieRequestDto){
        Movie updatedMovie = movieService.updateMovie(id, movieRequestDto);
        return new ResponseEntity<>(updatedMovie, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Movie> patchMovie(@PathVariable Long id, @RequestBody MovieRequestDto movieRequestDto) {
        Movie patchedMovie = movieService.patchMovie(id, movieRequestDto);
        return new ResponseEntity<>(patchedMovie, HttpStatus.OK);
    }







}
