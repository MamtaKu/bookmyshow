package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;


public interface ScreenRepository extends JpaRepository<Screen, Long> {
//    @Query("SELECT s FROM Screen s WHERE s.city = :city AND s.theatre = :theatre AND s.movie = :movie AND s.show = :show")
//    Screen findScreenByCityAndTheatreAndMovieAndShow(@Param("city") String city, @Param("theatre") String theatre, @Param("movie") String movie, @Param("show") String show);

    //@Query(value = "select s.* from screen as s join theatre as t on t.id = s.theatre_id join city c on c.id = t.city_id  where c.name = ?1  and t.name = ?2", nativeQuery = true)
    @Query("SELECT DISTINCT s FROM Screen s " +
            "JOIN s.theatre t " +
            "JOIN t.city c " +
            "WHERE c.name = :city AND t.name = :theatre")
    List<Screen> findScreenByCityAndTheatre(@Param("city") String city, @Param("theatre") String theatre);

    @Query("SELECT DISTINCT s FROM Screen s " +
            "JOIN s.shows sh " +
            "JOIN sh.movie m " +
            "JOIN s.theatre t " +
            "JOIN t.city c " +
            "WHERE c.name = :city AND t.name = :theatre AND m.name = :movie")
    List<Screen> findScreenByCityAndTheatreAndMovie(@Param("city") String city, @Param("theatre") String theatre, @Param("movie") String movie);


    @Query("SELECT DISTINCT s FROM Screen s " +
            "JOIN s.shows sh " +
            "JOIN sh.movie m " +
            "JOIN s.theatre t " +
            "JOIN t.city c " +
            "WHERE c.name = :city AND t.name = :theatre AND m.name = :movie AND sh.startTime = :startTime")
    Screen findScreenByCityAndTheatreAndMovieAndShow(@Param("city") String city, @Param("theatre") String theatre, @Param("movie") String movie, @Param("startTime") Date startTime);
}
