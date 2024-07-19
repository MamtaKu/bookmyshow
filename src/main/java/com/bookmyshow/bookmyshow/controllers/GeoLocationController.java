package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.services.GeoLocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/city")
public class GeoLocationController {

    private GeoLocationService geoLocationService;

    public GeoLocationController(GeoLocationService geoLocationService) {
        this.geoLocationService = geoLocationService;
    }

    @GetMapping("/ipAddress")
    public String getCityByIp(@RequestParam String ipAddress){
        return geoLocationService.getCityByIp(ipAddress);
    }
}
