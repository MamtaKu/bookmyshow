package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.services.TheatreService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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


    @PostMapping
    public ResponseEntity<Theatre> createTheatre(@RequestBody Theatre theatre){
        Theatre createdTheatre = theatreService.createTheatre(theatre);
        return new ResponseEntity<>(createdTheatre, HttpStatus.CREATED);

    }
    @PutMapping("/{id}")
    public ResponseEntity<Theatre> updateTheatre(@PathVariable("id") Long id, @RequestBody Theatre theatre) throws TheatreNotFoundException {
        Theatre updatedTheatre = theatreService.updateTheatre(id, theatre);
        return new ResponseEntity<>(updatedTheatre, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTheatre(@PathVariable("id") Long id) throws TheatreNotFoundException {
        theatreService.deleteTheatre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Theatre> patchTheatre(@PathVariable("id") Long id, @RequestBody Theatre partialTheatre) throws TheatreNotFoundException {
        Theatre patchedTheatre = theatreService.patchTheatre(id, partialTheatre);
        return new ResponseEntity<>(patchedTheatre, HttpStatus.OK);
    }
}
