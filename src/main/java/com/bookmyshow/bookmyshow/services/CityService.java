package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.City;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CityService {
   City getCityById(Long id);
   List<City>  getAllCity();
   City findByName(String name);

   City createCity(City city);

   void deleteCity(Long id);

   City updateCity(Long id, City city);

   City patchCity(Long id, City city);

}

