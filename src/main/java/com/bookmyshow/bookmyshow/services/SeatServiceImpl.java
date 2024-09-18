package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Seat;
import com.bookmyshow.bookmyshow.repositories.SeatRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeatServiceImpl implements SeatService {

    private final SeatRepository seatRepository;

    public SeatServiceImpl(SeatRepository seatRepository) {
        this.seatRepository = seatRepository;
    }

    @Override
    public Seat getSeatById(Long id) {
        Optional<Seat> byId = seatRepository.findById(id);
        Seat seat = byId.get();
        return seat;
    }

    @Override
    public List<Seat> getAllSeats() {
        List<Seat> seatList = seatRepository.findAll();
        return seatList;
    }
}
