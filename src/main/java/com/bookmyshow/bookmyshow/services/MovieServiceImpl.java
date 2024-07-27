package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.MovieRequestDto;
import com.bookmyshow.bookmyshow.exceptions.MovieAlreadyExistsException;
import com.bookmyshow.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.repositories.MovieRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
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
        movie.setFeatures(optionalMovie.get().getFeatures());
        movie.setShows(optionalMovie.get().getShows());
        return movie;

    }

    @Override
    public List<Movie> getAllMovie() {
        //List<Movie> movies = new ArrayList<>();
        List<Movie> allMovies = movieRepository.findAll();
//        for(Movie movie : allMovies){
//            movies.add(convertToMovie(movie));
//        }
        return allMovies;
    }

    @Override
    public List<Movie> getMoviesByCityAndTheatre(String city, String theatre) {
        List<Movie> byCityAndTheatre = movieRepository.findMoviesByCityAndTheatre(city, theatre);
        List<Movie> allMovies = new ArrayList<>();

        for(Movie movie : byCityAndTheatre ){
           //if("Bangalore".equalsIgnoreCase() && "Nexus".equalsIgnoreCase(movie.getShows().get())){
           //    allMovies.add(convertToMovie(movie));
            //}
        }
        return byCityAndTheatre;

    }

    @Override
    public Movie createMovie(MovieRequestDto movie) {
        Boolean b = movieRepository.existsByName(movie.getName());
        if(b){
            throw new MovieAlreadyExistsException("Movie Already Exists");
        }
        Movie movie1 = convertToMovie(movie);
        return  movieRepository.save(movie1);

    }

    @Override
    public void deleteMovie(Long id) {
        if(!movieRepository.existsById(id)){
            throw new MovieNotFoundException("Movie is not present with this id " + id);

        }
        movieRepository.deleteById(id);
    }

    @Override
    public Movie updateMovie(Long id, MovieRequestDto movieRequestDto) {

        Optional<Movie> byId = movieRepository.findById(id);
        if(byId.isPresent()) {

            Movie existingMovie = byId.get();
            existingMovie.setName(movieRequestDto.getName());
            existingMovie.setFeatures(movieRequestDto.getFeatures());
            existingMovie.setDescription(movieRequestDto.getDescription());
            Movie updatedMovie = movieRepository.save(existingMovie);

            return updatedMovie;
        }
        else{
            throw new MovieNotFoundException("Movie not exists with this id :" + id);
        }



    }

    public Movie patchMovie(Long id, MovieRequestDto movieRequestDto) {
        Movie movie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));

        if (movieRequestDto.getName() != null) {
            movie.setName(movieRequestDto.getName());
        }
        if (movieRequestDto.getDescription() != null) {
            movie.setDescription(movieRequestDto.getDescription());
        }
        if (movieRequestDto.getFeatures() != null) {
            movie.setFeatures(movieRequestDto.getFeatures());
        }

        return movieRepository.save(movie);
    }

    @Override
    public Movie findByName(String name) {

        Optional<Movie> byName = Optional.ofNullable(movieRepository.findByName(name));
        return byName.get();

    }

    private Movie convertToMovie(MovieRequestDto movieObj) {
        Movie movie = new Movie();
        movie.setId(movieObj.getId());
        movie.setName(movieObj.getName());
        movie.setFeatures(movieObj.getFeatures());
        movie.setDescription(movieObj.getDescription());
       // movie.setShows(movieObj.getShows());
        return movie;
    }





}
