package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.services.CityService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
