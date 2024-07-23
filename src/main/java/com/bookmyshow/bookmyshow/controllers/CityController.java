package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.services.CityService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/city")
public class CityController {

    private CityService cityService;

    public CityController(CityService cityService) {
        this.cityService = cityService;
    }

    @GetMapping("/{id}")
    public City getCityById(@PathVariable("id") Long id){
        return cityService.getCityById(id);

    }


    @GetMapping
    public List<City> getAllCity(){

        return cityService.getAllCity();
    }


    @PostMapping
    public ResponseEntity<City> createCity(@RequestBody City city){
        City createdCity = cityService.createCity(city);

        return new ResponseEntity<>(createdCity, HttpStatus.CREATED);

    }

    @PutMapping("/{id}")
    public ResponseEntity<City> updateCity(@PathVariable("id") Long id, @RequestBody City city) {
        City updatedCity = cityService.updateCity(id, city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<City> patchCity(@PathVariable("id") Long id, @RequestBody City city){
        City updatedCity = cityService.patchCity(id, city);
        return new ResponseEntity<>(updatedCity, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>  deleteCity(@PathVariable("id") Long id) {
        cityService.deleteCity(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }




}
