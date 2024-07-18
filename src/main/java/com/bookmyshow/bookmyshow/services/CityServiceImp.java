package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.CityRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class CityServiceImp implements CityService {

    private CityRepository cityRepository;

    public CityServiceImp(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    @Override
    public City getCityById(Long id) {
        City city = new City();

        Optional<City> byId = cityRepository.findById(id);
        City optionalCity1 = byId.get();
        city.setId(optionalCity1.getId());
        city.setName(optionalCity1.getName());
        city.setTheatres(optionalCity1.getTheatres());
//        List<Theatre> theatres = optionalCity1.getTheatres();
//
//        for(Theatre theatre : theatres){
//            city.setTheatres(Arrays.asList(theatre));
//        }

        return city;


    }

    @Override
    public List<City> getAllCity() {
        List<City> cities = new ArrayList<>();
        List<City> allcity = cityRepository.findAll();


//        for(City city: allcity){
//           cities.add(convertToCity(city));
//        }

        return allcity;
    }


    private static City convertToCity(City cityObj){
        City city = new City();
        city.setId(cityObj.getId());
        city.setName(cityObj.getName());
        //city.setTheatres(cityObj.getTheatres());
//        List<Theatre> theatres = cityObj.getTheatres();
//
//        for(Theatre theatre : theatres){
//            city.setTheatres(Arrays.asList(theatre));
//        }

        return city;
    }
}
