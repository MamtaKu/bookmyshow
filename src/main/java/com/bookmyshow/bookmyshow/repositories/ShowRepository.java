package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Override
    Optional<Show> findById(Long id);

    boolean existsByScreen_Name(String showRequestDto);

    boolean existsByScreenIdAndStartTime(Long screenId, LocalDateTime startTime);


}
