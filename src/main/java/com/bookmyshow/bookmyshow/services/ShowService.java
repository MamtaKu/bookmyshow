package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.ShowRequestDto;
import com.bookmyshow.bookmyshow.models.Show;

import java.util.List;

public interface ShowService {
    Show getShowById(Long id);
    List<Show> getAllShows();

    Show createShow(ShowRequestDto showRequestDto);

    void deleteShow(Long id);
    Show updateShow(Long id, ShowRequestDto showRequestDto);
    Show patchShow(Long id, ShowRequestDto showRequestDto);
}
