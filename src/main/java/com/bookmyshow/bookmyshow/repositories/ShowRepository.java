package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Show;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShowRepository extends JpaRepository<Show, Long> {

    @Override
    Optional<Show> findById(Long id);

    boolean existsByScreen_Name(String showRequestDto);
}
