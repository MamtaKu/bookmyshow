package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Seat;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeatRepository extends JpaRepository<Seat, Long> {
}