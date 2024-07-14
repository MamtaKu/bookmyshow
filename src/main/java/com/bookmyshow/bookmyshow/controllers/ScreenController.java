package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.services.ScreenService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
