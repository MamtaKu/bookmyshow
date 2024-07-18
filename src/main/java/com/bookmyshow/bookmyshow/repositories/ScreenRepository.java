package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


public interface ScreenRepository extends JpaRepository<Screen, Long> {
//    @Query("SELECT s FROM Screen s WHERE s.city = :city AND s.theatre = :theatre AND s.movie = :movie AND s.show = :show")
//    Screen findScreenByCityAndTheatreAndMovieAndShow(@Param("city") String city, @Param("theatre") String theatre, @Param("movie") String movie, @Param("show") String show);
}
