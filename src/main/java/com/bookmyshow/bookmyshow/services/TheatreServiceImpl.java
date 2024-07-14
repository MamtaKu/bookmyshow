package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;
    @Override
    public List<Theatre> getAllTheatres() {

        return theatreRepository.findAll();
    }
}
