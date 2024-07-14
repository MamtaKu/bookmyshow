package com.bookmyshow.bookmyshow.controllers;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketControllerRest {

    @GetMapping("/{id}")
    public String getTicketById(@PathVariable("id") Long id){
        return "Hello";

    }

    @GetMapping
    public void getAllTickets(){

    }

    @PostMapping
    public void createTicket(){

    }

    @DeleteMapping("/{id}")
    public void deleteTicketById(){

    }

    @PutMapping("/{id}")
    public void updateTicketById(){

    }




}
