package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;

    @Override
    public Theatre getTheatreById(Long id) {
        Optional<Theatre> optionalTheater = theatreRepository.findById(id);
        Theatre theatre = new Theatre();
        theatre.setId(optionalTheater.get().getId());
        theatre.setName(optionalTheater.get().getName());



        return theatre;
 }

    @Override
    public List<Theatre> getAllTheatres() {

        return theatreRepository.findAll();
    }
}
