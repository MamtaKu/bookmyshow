package com.bookmyshow.bookmyshow.services;


import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ScreenService {
    Screen getScreenById(Long id);
    List<Screen> getAllScreens();

}
