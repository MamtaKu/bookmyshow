package com.bookmyshow.bookmyshow.services;


import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ScreenService {
    Screen getScreenById(Long id);
    List<Screen> getAllScreens();


    Screen getScreenNameByCityAndTheatreAndMovieAndShow(String city, String theatre);

    @Query("SELECT DISTINCT m FROM Movie m " +
            "JOIN m.shows s " +
            "JOIN s.screen sc " +
            "JOIN sc.theatre t " + // Change this according to your actual entity relationships
            "JOIN t.city c " +
            "WHERE c.name = :city AND t.name = :theatre")
    List<Movie> getAllScreenByCity(@Param("city") String city, @Param("theatre") String theatre);

}
