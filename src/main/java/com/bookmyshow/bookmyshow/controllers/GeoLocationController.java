package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.services.GeoLocationService;
import com.bookmyshow.bookmyshow.services.IpGeolocationService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/city")
public class GeoLocationController {

    private IpGeolocationService ipGeoLocationService;

    public GeoLocationController(IpGeolocationService ipGeoLocationService) {
        this.ipGeoLocationService = ipGeoLocationService;
    }

    @GetMapping("/byIpAddressAndAccessKey")
    public String getCityByIp(@RequestParam String ipAddress,@RequestParam String access_key) throws IOException {

        return ipGeoLocationService.getCityByIp(ipAddress,access_key);
    }
}
