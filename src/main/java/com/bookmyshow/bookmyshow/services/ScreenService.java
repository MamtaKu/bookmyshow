package com.bookmyshow.bookmyshow.services;


import com.bookmyshow.bookmyshow.dtos.ScreenRequestDto;
import com.bookmyshow.bookmyshow.models.Screen;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Date;
import java.util.List;

public interface ScreenService {
    Screen getScreenById(Long id);
    List<Screen> getAllScreens();

    List<Screen> getScreenByCityAndTheatre(String city, String theatre);

    List<Screen> getScreenByCityAndTheatreAndMovie(String city, String theatre, String movie);

    Screen getScreenByCityAndTheatreAndMovieAndShow(String city, String theatre, String movie, Date startTime);

    Screen createScreen(ScreenRequestDto screenRequestDto);

    Screen updateScreen(Long id, ScreenRequestDto screenRequestDto);
    void deleteScreen(Long id);

    Screen patchScreen(Long id, ScreenRequestDto screenRequestDto);

    Screen findByName(String name);
}
