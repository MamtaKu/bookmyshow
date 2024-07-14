package com.bookmyshow.bookmyshow.services;


import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ScreenService {
    Screen getScreenById(Long id);

}
