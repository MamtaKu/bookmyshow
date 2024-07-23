package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long> {
    @Override
    Movie save(Movie  movie);

    //List<Movie> findByCityNameAndTheatreName(String city, String theatre);

//    @Query("SELECT DISTINCT m from Movie m join shows sh on m.id = sh.movie_id join Screen sc on sc.id = sh.screen_id join theatre t on t.id = sc.theatre_id join City c on c.id = t.city_id where c.name = ? and t.name = ?")

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN m.shows s " +
            "JOIN s.screen sc " +
            "JOIN sc.theatre t " +
            "JOIN t.city c " +
            "WHERE c.name = :city AND t.name = :theatre")
    List<Movie> findMoviesByCityAndTheatre(@Param("city") String city, @Param("theatre") String theatre);

    Boolean existsByName(String name);
}
