package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    Movie save(Movie  movie);
}
