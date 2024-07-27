package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.ScreenRequestDto;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.services.ScreenService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping
    public ResponseEntity<Screen> createScreen(@RequestBody ScreenRequestDto screenRequestDto){
        Screen createdScreen = screenService.createScreen(screenRequestDto);
        return new ResponseEntity<>(createdScreen, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Screen> updateScreen(@PathVariable Long id, @RequestBody ScreenRequestDto screenRequestDto){
        Screen updateScreen = screenService.updateScreen(id, screenRequestDto);
        return new ResponseEntity<>(updateScreen, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteScreen(@PathVariable Long id){
        screenService.deleteScreen(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PatchMapping("/{id}")
    public ResponseEntity<Screen> patchScreen(@PathVariable Long id, @RequestBody ScreenRequestDto screenRequestDto){
        Screen patchedScreen = screenService.patchScreen(id, screenRequestDto);
        return new ResponseEntity<>(patchedScreen, HttpStatus.OK);
    }


}
