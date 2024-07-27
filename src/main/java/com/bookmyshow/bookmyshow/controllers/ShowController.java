package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.dtos.ShowRequestDto;
import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.services.ShowService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService) {

        this.showService = showService;
    }

    @GetMapping("/{id}")
    public Show getShowById(@PathVariable Long id){

        return showService.getShowById(id);
    }

    @GetMapping
    public List<Show> getAllShows(){
        return showService.getAllShows();
    }

    @PostMapping
    public ResponseEntity<Show> createShow(@RequestBody ShowRequestDto showRequestDto){

        return new ResponseEntity<>(showService.createShow(showRequestDto), HttpStatus.CREATED);
    }


}
