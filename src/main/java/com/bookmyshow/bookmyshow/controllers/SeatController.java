package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.Seat;
import com.bookmyshow.bookmyshow.services.SeatService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/seats")
public class SeatController {
    private SeatService seatService;

    public SeatController(SeatService seatService) {
        this.seatService = seatService;
    }

    @GetMapping("/{id}")
    public Seat getSeatById(@PathVariable Long id){
        return seatService.getSeatById(id);

    }
    @GetMapping
    public List<Seat> getAllSeats(){
        return seatService.getAllSeats();
    }
}
