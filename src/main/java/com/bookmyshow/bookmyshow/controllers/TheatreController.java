package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.services.TheatreService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
