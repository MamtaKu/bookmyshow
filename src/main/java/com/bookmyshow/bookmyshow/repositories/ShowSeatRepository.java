package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.enums.SeatType;
import com.bookmyshow.bookmyshow.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<Movie.ShowSeat, Long> {
    @Override
    Optional<Movie.ShowSeat> findById(Long showSeatId);


    //select * from ShowSeat where id IN(1, 2,3 4)
//    List<ShowSeat> findAllById(List<Long> showSeatIds);

    Movie.ShowSeat save(SeatType seatType);
}
