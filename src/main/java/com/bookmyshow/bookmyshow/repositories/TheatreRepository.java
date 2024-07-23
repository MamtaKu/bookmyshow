package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Override
    List<Theatre> findAll();

    List<Theatre> findByCity_name(String name);

    @Query("SELECT DISTINCT t FROM Theatre t " +
            "JOIN t.screens sc " +
            "JOIN sc.shows s " +
            "JOIN s.movie m " +
            "JOIN t.city c " +
            "WHERE c.name = :city AND m.name = :movie")
    List<Theatre> findTheatresByCityAndMovie(@Param("city") String city,@Param("movie") String movie);

    boolean existsByName(String name);

    boolean existsByCityName(City city);
}