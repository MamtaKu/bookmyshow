package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieServiceImpl implements MovieService {

    private final MovieRepository movieRepository;

    public MovieServiceImpl(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }

    @Override
    public Movie getMovieById(Long id) {
        Movie movie = new Movie();
        Optional<Movie> optionalMovie = movieRepository.findById(id);
        movie.setId(optionalMovie.get().getId());
        movie.setName(optionalMovie.get().getName());
        movie.setDescription((optionalMovie.get().getDescription()));
        movie.setFeatureEnums(optionalMovie.get().getFeatureEnums());
        return movie;

    }
}
