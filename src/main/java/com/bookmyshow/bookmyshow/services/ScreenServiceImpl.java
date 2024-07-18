package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.repositories.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements  ScreenService{

    private  ScreenRepository screenRepository;

    public ScreenServiceImpl(ScreenRepository screenRepository) {
        this.screenRepository = screenRepository;
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
        return allScreens;


    }

    @Override
    public List<Screen> getScreenByCityAndTheatre(String city, String theatre) {
        List<Screen> screenByCityAndTheatre = screenRepository.findScreenByCityAndTheatre(city, theatre);
        return screenByCityAndTheatre;

    }

    @Override
    public List<Screen> getScreenByCityAndTheatreAndMovie(String city, String theatre, String movie) {
        List<Screen> screenByCityAndTheatreAndMovie = screenRepository.findScreenByCityAndTheatreAndMovie(city, theatre, movie);
        return screenByCityAndTheatreAndMovie;

    }

    @Override
    public Screen getScreenByCityAndTheatreAndMovieAndShow(String city, String theatre, String movie, Date startTime) {
        return screenRepository.findScreenByCityAndTheatreAndMovieAndShow(city, theatre, movie, startTime);
    }
//
//    @Override
//    public List<Screen> getScreenNameByCityAndTheatre(String city, String theatre) {
//        screenRepository.findScreenByCityAndTheatre(city, theatre);
//        return screenByCityAndTheatre;
//
//    }







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
