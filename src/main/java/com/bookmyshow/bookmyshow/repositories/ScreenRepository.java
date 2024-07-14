package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface ScreenRepository extends JpaRepository<Screen, Long> {
}