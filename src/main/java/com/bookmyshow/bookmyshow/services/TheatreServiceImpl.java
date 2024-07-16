package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;

    public TheatreServiceImpl(TheatreRepository theatreRepository) {
        this.theatreRepository = theatreRepository;
    }

    @Override
    public Theatre getTheatreById(Long id) {
        Optional<Theatre> optionalTheater = theatreRepository.findById(id);
        Theatre theatre = new Theatre();
        theatre.setId(optionalTheater.get().getId());
//        theatre.setName(optionalTheater.get().getName());
//        theatre.setScreens(optionalTheater.get().getScreens());



        return theatre;
 }

    @Override
    public List<Theatre> getAllTheatres() {

        return theatreRepository.findAll();
    }

    @Override
    public List<Theatre> getTheatresByCity(String city) {
        List<Theatre> allTheatres = theatreRepository.findByCity_name(city);
        List<Theatre> result = new ArrayList<>();

        for(Theatre theatre : allTheatres ) {


            if ("Bangalore".equalsIgnoreCase(theatre.getCity().getName())) {
                result.add(convertToTheatre(theatre));
            }
            else if("Mumbai".equalsIgnoreCase(theatre.getCity().getName())){
                result.add(convertToTheatre(theatre));
            }
            else if("Kolkata".equalsIgnoreCase(theatre.getCity().getName())){
                result.add(convertToTheatre(theatre));
            }
        }
        return result;

    }

    private Theatre convertToTheatre(Theatre theatreObj) {
        Theatre theatre = new Theatre();
        theatre.setId(theatreObj.getId());
        theatre.setCity(theatreObj.getCity());
        theatre.setName(theatreObj.getName());
        return theatre;

    }


}
