package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.services.TheatreService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/theatres")
public class TheatreController {

    private TheatreService theatreService;

    public TheatreController(TheatreService theatreService) {
        this.theatreService = theatreService;
    }

    @GetMapping("/{id}")
    public Theatre getTheaterById(@PathVariable("id") Long id){

        return theatreService.getTheatreById(id);
    }

    @GetMapping
    public List<Theatre> getAllTheaters(){
        return theatreService.getAllTheatres();

    }

    @GetMapping("/city")
    public List<Theatre> getTheatresByCity(@RequestParam("city") String city){
        return theatreService.getTheatresByCity(city);
    }

    @GetMapping("/byCityAndMovie")
    public List<Theatre> getTheatresByCityAndMovie(@RequestParam("city") String city, @RequestParam("movie") String movie){
        return theatreService.getTheatresByCityAndMovie(city, movie);
    }
}
