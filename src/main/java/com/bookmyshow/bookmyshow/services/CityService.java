package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityService {
   City getCityById(Long id);
   List<City>  getAllCity();
}

