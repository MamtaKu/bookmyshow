package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.bookmyshow.models.Theatre;

import java.util.List;

public interface TheatreService {

    Theatre getTheatreById(Long id);
    List<Theatre> getAllTheatres();

    List<Theatre> getTheatresByCity(String name);

    List<Theatre> getTheatresByCityAndMovie(String city, String theatre);
    Theatre createTheatre(Theatre thaetre);
    Theatre updateTheatre(Long id, Theatre theatre) throws TheatreNotFoundException;
    void deleteTheatre(Long id) throws TheatreNotFoundException;
    Theatre patchTheatre(Long id, Theatre partialTheatre) throws TheatreNotFoundException;
}
