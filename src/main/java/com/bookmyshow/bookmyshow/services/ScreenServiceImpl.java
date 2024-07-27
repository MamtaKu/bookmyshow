package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.ScreenRequestDto;
import com.bookmyshow.bookmyshow.exceptions.MovieNotFoundException;
import com.bookmyshow.bookmyshow.exceptions.ScreenNotFoundException;
import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.ScreenRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ScreenServiceImpl implements  ScreenService{

    private  ScreenRepository screenRepository;

    private TheatreService theatreService;

    public ScreenServiceImpl(ScreenRepository screenRepository, TheatreService theatreService) {
        this.screenRepository = screenRepository;
        this.theatreService = theatreService;
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

    @Override
    public Screen createScreen(ScreenRequestDto screenRequestDto) {
        if(screenRepository.existsByName(screenRequestDto.getName())){
            throw new RuntimeException("Screen already exists");
        }

        Theatre theatre = screenRequestDto.getTheatre();
        Optional<Theatre> byName = Optional.ofNullable(theatreService.findByName(theatre.getName()));
        if (byName.isPresent()) {
            screenRequestDto.setTheatre(byName.get());
        } else {
            theatreService.createTheatre(theatre);
        }

        Screen screen = new Screen();
        screen.setName(screenRequestDto.getName());
        screen.setTheatre(screenRequestDto.getTheatre());
        screen.setFeatures(screenRequestDto.getFeatures());
        return screenRepository.save(screen);
    }

    @Override
    public Screen updateScreen(Long id, ScreenRequestDto screenRequestDto) {
        Optional<Screen> existingScreeen = screenRepository.findById(id);
        if(existingScreeen.isPresent()) {
            Screen updatedScreen = existingScreeen.get();
            Theatre theatre = screenRequestDto.getTheatre();
            Optional<Theatre> byName = Optional.ofNullable(theatreService.findByName(theatre.getName()));
            if(byName.isPresent()){
                updatedScreen.setTheatre(byName.get());
            }
            else{
                theatreService.createTheatre(theatre);
            }


            updatedScreen.setName(screenRequestDto.getName());
            updatedScreen.setFeatures(screenRequestDto.getFeatures());

            screenRepository.save(updatedScreen);

            return updatedScreen;
        }
        else{
            throw new ScreenNotFoundException("Screen not exists with this id :" + id);
        }
    }

    @Override
    public void deleteScreen(Long id) {
        if(!screenRepository.existsById(id)){
            throw new RuntimeException("Screen Not exists");

        }
         screenRepository.deleteById(id);
    }

    @Override
    public Screen patchScreen(Long id, ScreenRequestDto screenRequestDto) {
        Optional<Screen> existingScreen = screenRepository.findById(id);
        if(existingScreen.isPresent()){
        Screen existedScreen = existingScreen.get();


        if(screenRequestDto.getName() != null){
            existedScreen.setName(screenRequestDto.getName());
        }
        if(screenRequestDto.getFeatures() != null){
            existedScreen.setFeatures(screenRequestDto.getFeatures());
        }
        if(screenRequestDto.getTheatre() != null){
            existedScreen.setTheatre(screenRequestDto.getTheatre());
        }

            Screen save = screenRepository.save(existedScreen);
        return save;
        }
        else{
            throw new ScreenNotFoundException("Screen not found with id :"+ id);
        }
    }

    @Override
    public Screen findByName(String name) {
        Optional<Screen> byName = Optional.ofNullable(screenRepository.findByName(name));
        return byName.get();
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
