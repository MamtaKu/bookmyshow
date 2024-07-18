package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.repositories.CityRepository;
import com.bookmyshow.bookmyshow.repositories.ScreenRepository;
import com.bookmyshow.bookmyshow.repositories.TheatreRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements  ScreenService{

    private final CityRepository cityRepository;
    private  ScreenRepository screenRepository;
    private CityServiceImp cityServiceImp;
    private TheatreRepository theatreRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository, CityServiceImp cityServiceImp, TheatreRepository theatreRepository, CityRepository cityRepository) {
        this.screenRepository = screenRepository;
        this.cityServiceImp = cityServiceImp;
        this.theatreRepository = theatreRepository;
        this.cityRepository = cityRepository;
    }

    @Override
    public Screen getScreenById(Long id) {
        Optional<Screen> optionalScreen = screenRepository.findById(id);
            Screen screen = new Screen();
            screen.setId(optionalScreen.get().getId());
            screen.setName(optionalScreen.get().getName());
            screen.setTheatre(optionalScreen.get().getTheatre());
            screen.setSeats(optionalScreen.get().getSeats());
            screen.setFeatures(optionalScreen.get().getFeatures());
            return screen;



    }

    @Override
    public List<Screen> getAllScreens() {
        List<Screen> screens = new ArrayList<>();
        List<Screen> allScreens = screenRepository.findAll();

        for(Screen screen : allScreens){
            screens.add(convertToScreen(screen));
        }
        return screens;


    }

    @Override
    public Screen getScreenNameByCityAndTheatreAndMovieAndShow(String city, String theatre) {
        return  screenRepository.getScreenByCityAndTheatre(city,theatre);
    }

    @Override
    public List<Movie> getAllScreenByCity(String city, String theatre) {
        return List.of();
    }


    private Screen convertToScreen(Screen screenObj) {
        Screen screen = new Screen();
        screen.setId(screenObj.getId());
        screen.setName(screenObj.getName());
        //.setTheatre(screenObj.getTheatre());
       // screen.setFeatures(screenObj.getFeatures());
       // screen.setSeats(screenObj.getSeats());
        return screen;

    }


}
