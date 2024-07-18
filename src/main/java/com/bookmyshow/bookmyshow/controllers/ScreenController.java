package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.services.ScreenService;
import org.springframework.web.bind.annotation.*;

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
    @GetMapping("/byCityAndTheatreAndMovieAndShows")
    public Screen getScreenNameByCityAndTheatreAndMovieAndShows(@RequestParam String city,@RequestParam String theatre,@RequestParam String movie,@RequestParam String show ){
        return screenService.getScreenNameByCityAndTheatreAndMovieAndShow(city,theatre,movie,show);
    }
}
