package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.services.ShowService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/shows")
public class ShowController {

    private ShowService showService;

    public ShowController(ShowService showService) {
        this.showService = showService;
    }

    @GetMapping("/{id}")
    public Show getShowById(Long id){
        return showService.getShowById(id);
    }
}
