package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.services.ScreenService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/screens")
public class ScreenController {
    private ScreenService screenService;

    public ScreenController(ScreenService screenService) {
        this.screenService = screenService;
    }

    @GetMapping("/{id}")
    public Screen getScreenById(@PathVariable("{id}") Long id){

        return screenService.getScreenById(id);
    }

    @GetMapping
    public List<Screen>  getAllScreens(){

        return screenService.getAllScreens();
    }

    //get screen name
    @GetMapping("/byCityAndTheatre")
    public List<Screen> getScreenByCityAndTheatre(@RequestParam String city,@RequestParam String theatre){
        return screenService.getScreenByCityAndTheatre(city, theatre);
    }


    @GetMapping("/byCityAndTheatreAndMovie")
    public List<Screen> getScreenByCityAndTheatreAndMovie(@RequestParam String city,@RequestParam String theatre, @RequestParam String movie){
        return screenService.getScreenByCityAndTheatreAndMovie(city, theatre, movie);
    }

    @GetMapping("/byCityAndTheatreAndMovieAndShowStartTime")
    public Screen getScreenByCityAndTheatreAndMovieAndShow(@RequestParam String city, @RequestParam String theatre, @RequestParam String movie, @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) Date startTime){
        return screenService.getScreenByCityAndTheatreAndMovieAndShow(city, theatre, movie, startTime);
    }
}
