package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CityRepository extends JpaRepository<City, Long> {

    @Override
    List<City> findAll();


}