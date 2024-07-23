package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.exceptions.CityAlreadyExistsException;
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

    @Override
    public City findByName(String name) {
        Optional<City> byName = cityRepository.findByName(name);
        return byName.get();

    }

    @Override
    public City createCity(City city) {

        if(cityRepository.existsByName(city.getName())){
            throw new CityAlreadyExistsException("City Already exists");
        }

            City city1 = convertToCity(city);



       return cityRepository.save(city1);


    }

    @Override
    public void deleteCity(Long id) {
        if(!cityRepository.existsById(id)){
            throw new RuntimeException("City not found with id "+ id);

        }

        cityRepository.deleteById(id);
    }

    @Override
    public City updateCity(Long id, City city) {
        if(!cityRepository.existsById(id))
            throw new RuntimeException("City not found with id "+ id);

        Optional<City> optionalCity = cityRepository.findById(id);
        City existingCity = optionalCity.get();

        existingCity.setName(city.getName());
        existingCity.setTheatres(city.getTheatres());
        return cityRepository.save(existingCity);
   }

    @Override
    public City patchCity(Long id, City city) {
        if(!cityRepository.existsById(id))
            throw new RuntimeException("City not found with id "+ id);

        Optional<City> optionalCity = cityRepository.findById(id);
        City existingCity = optionalCity.get();
        existingCity.setName(city.getName());
        return cityRepository.save(existingCity);
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
