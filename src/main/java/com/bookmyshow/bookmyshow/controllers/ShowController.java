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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteShow(@PathVariable Long id){
        showService.deleteShow(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Show> updateShow(@PathVariable Long id, @RequestBody ShowRequestDto showRequestDto){
        Show updatedShow = showService.updateShow(id, showRequestDto);
        return new ResponseEntity<>(updatedShow, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Show> patchShow(@PathVariable Long id, @RequestBody ShowRequestDto showRequestDto) {
        Show patchedShow = showService.patchShow(id, showRequestDto);
        return new ResponseEntity<>(patchedShow, HttpStatus.OK);
    }


}
