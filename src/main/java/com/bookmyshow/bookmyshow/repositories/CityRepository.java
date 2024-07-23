package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    List<City> findAll();


    City save(City city);

    boolean existsByName(String city);



    Optional<City> findByName(String name);
}