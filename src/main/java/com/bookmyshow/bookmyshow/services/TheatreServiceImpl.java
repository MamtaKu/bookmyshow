package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TheatreServiceImpl implements TheatreService {
    private TheatreRepository theatreRepository;
    private CityService cityService;

    public TheatreServiceImpl(TheatreRepository theatreRepository, CityService cityService) {
        this.theatreRepository = theatreRepository;
        this.cityService = cityService;
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
//        List<Theatre> result = new ArrayList<>();
//
//        for(Theatre theatre : allTheatres ) {
//
//
//            if ("Bangalore".equalsIgnoreCase(theatre.getCity().getName())) {
//                result.add(convertToTheatre(theatre));
//            }
//            else if("Mumbai".equalsIgnoreCase(theatre.getCity().getName())){
//                result.add(convertToTheatre(theatre));
//            }
//            else if("Kolkata".equalsIgnoreCase(theatre.getCity().getName())){
//                result.add(convertToTheatre(theatre));
//            }
//        }
        return allTheatres;

    }

    @Override
    public List<Theatre> getTheatresByCityAndMovie(String city, String movie) {
        List<Theatre> theatres = theatreRepository.findTheatresByCityAndMovie(city,movie);
        return theatres;


    }

    @Override
    public Theatre createTheatre(Theatre theatre) {

        if(theatreRepository.existsByName(theatre.getName())){
            throw new RuntimeException("Theatre already exists");
        }

        City city = theatre.getCity();
        Optional<City> byName = Optional.ofNullable(cityService.findByName(city.getName()));
        if (byName.isPresent()) {
            theatre.setCity(byName.get());
        } else {
            cityService.createCity(city);
        }
        return theatreRepository.save(theatre);
     }

    public Theatre updateTheatre(Long id, Theatre theatre) throws TheatreNotFoundException {

        Optional<Theatre> existingTheatre = theatreRepository.findById(id);
        if (existingTheatre.isPresent()) {
            Theatre updatedTheatre = existingTheatre.get();
            City city = theatre.getCity();
            Optional<City> byName = Optional.ofNullable(cityService.findByName(city.getName()));
            if (byName.isPresent()) {
                updatedTheatre.setCity(byName.get());
            } else {
                cityService.createCity(city);
            }
            updatedTheatre.setName(theatre.getName());
            //updatedTheatre.setCity(theatre.getCity());
            updatedTheatre.setScreens(theatre.getScreens());
            return theatreRepository.save(updatedTheatre);
        } else {
            throw new TheatreNotFoundException("Theatre not found with id " + id);
        }
    }


    public void deleteTheatre(Long id) throws TheatreNotFoundException {

        if (!theatreRepository.existsById(id)) {
            throw new TheatreNotFoundException("Theatre with id " + id + " not found");
        }
        theatreRepository.deleteById(id);
    }

    public Theatre patchTheatre(Long id, Theatre partialTheatre) throws TheatreNotFoundException {
        Optional<Theatre> existingTheatre = theatreRepository.findById(id);
        if (existingTheatre.isPresent()) {
            Theatre currentTheatre = existingTheatre.get();
            if (partialTheatre.getName() != null) {
                currentTheatre.setName(partialTheatre.getName());
            }
            if (partialTheatre.getCity() != null){
                currentTheatre.setCity(partialTheatre.getCity());
            }
            if(partialTheatre.getScreens() != null){
                currentTheatre.setScreens(partialTheatre.getScreens());
            }

            return theatreRepository.save(currentTheatre);
        } else {
            throw new TheatreNotFoundException("Theatre not found with id " + id);
        }
    }

    private Theatre convertToTheatre(Theatre theatreObj) {
        Theatre theatre = new Theatre();
        theatre.setId(theatreObj.getId());
        theatre.setCity(theatreObj.getCity());
        theatre.setName(theatreObj.getName());
        return theatre;

    }


}
