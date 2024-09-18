package com.bookmyshow.bookmyshow.services;


import com.bookmyshow.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeatService {
    Seat getSeatById(Long id);
    List<Seat> getAllSeats();

}
