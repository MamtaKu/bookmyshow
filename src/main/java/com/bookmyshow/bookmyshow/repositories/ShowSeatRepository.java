package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.SeatType;
import com.bookmyshow.bookmyshow.models.ShowSeat;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ShowSeatRepository extends JpaRepository<ShowSeat, Long> {
    @Override
    Optional<ShowSeat> findById(Long showSeatId);


    //select * from ShowSeat where id IN(1, 2,3 4)
//    List<ShowSeat> findAllById(List<Long> showSeatIds);

    ShowSeat save(SeatType seatType);
}
