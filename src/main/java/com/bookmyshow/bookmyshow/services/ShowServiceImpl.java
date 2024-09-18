package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.ScreenRequestDto;
import com.bookmyshow.bookmyshow.dtos.ShowRequestDto;
import com.bookmyshow.bookmyshow.exceptions.ShowAlreadyExistsException;
import com.bookmyshow.bookmyshow.exceptions.ShowNotFoundException;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.ShowRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService{

    private MovieService movieService;
    private ScreenService screenService;
    private TheatreService theatreService;
    private  ShowRepository showRepository;

    public ShowServiceImpl(MovieService movieService, ScreenService screenService, TheatreService theatreService, ShowRepository showRepository) {
        this.movieService = movieService;
        this.screenService = screenService;
        this.theatreService = theatreService;
        this.showRepository = showRepository;
    }

    @Override
    public Show getShowById(Long id) {
        Show show = new Show();
        Optional<Show> optionalShow = showRepository.findById(id);
        show.setId(optionalShow.get().getId());
        show.setStartTime(optionalShow.get().getStartTime());
        show.setEndTime(optionalShow.get().getEndTime());
        show.setMovie(optionalShow.get().getMovie());
        show.setScreen(optionalShow.get().getScreen());
        show.setFeatures(optionalShow.get().getFeatures());
        return show;
    }

    public List<Show> getAllShows(){
        return showRepository.findAll();
    }

    @Override
    @Transactional
    public Show createShow(ShowRequestDto showRequestDto) {
        if (showRepository.existsByScreenIdAndStartTime(showRequestDto.getScreenId(), showRequestDto.getStartTime())) {
            throw new ShowAlreadyExistsException("Show already exists for this screen at the given start time");
        }

        Movie movie = movieService.getMovieById(showRequestDto.getMovieId());
        Screen screen = screenService.getScreenById(showRequestDto.getScreenId());
        Theatre theatre = theatreService.getTheatreById(showRequestDto.getTheatreId());


        Show show = new Show();

        show.setFeatures(showRequestDto.getFeatures());
        show.setStartTime(showRequestDto.getStartTime());
        show.setEndTime(showRequestDto.getEndTime());
        show.setFeatures(showRequestDto.getFeatures());
        show.setMovie(movie);
        show.setScreen(screen);
        show.setTheatre(theatre);

        return showRepository.save(show);
    }

    @Override
    public void deleteShow(Long id) {
        if(!showRepository.existsById(id)){
            throw new RuntimeException("Show not exists");

        }
        showRepository.deleteById(id);
    }

    @Override
    public Show updateShow(Long id, ShowRequestDto showRequestDto) {
        Optional<Show> byId = showRepository.findById(id);
        if (byId.isPresent()) {
            Show show = byId.get();
            show.setId(id);
            Movie movie = movieService.getMovieById(showRequestDto.getMovieId());
            Screen screen = screenService.getScreenById(showRequestDto.getScreenId());
            Theatre theatre = theatreService.getTheatreById(showRequestDto.getTheatreId());

            show.setTheatre(theatre);
            show.setMovie(movie);
            show.setScreen(screen);
            show.setStartTime(showRequestDto.getStartTime());
            show.setEndTime(showRequestDto.getEndTime());
            show.setFeatures(showRequestDto.getFeatures());

            showRepository.save(show);
            return show;

        }
        else{
            throw new ShowNotFoundException("Show is not present with this id :" + id);
        }

    }

    @Override
    public Show patchShow(Long id, ShowRequestDto showRequestDto) {
        Optional<Show> byId = showRepository.findById(id);
        if(byId.isPresent()){
            Show show = byId.get();


            if(showRequestDto.getScreenId() != null){
                Screen screen = screenService.getScreenById(showRequestDto.getScreenId());
                show.setScreen(screen);
            }
            if(showRequestDto.getMovieId() != null){
                Movie movie = movieService.getMovieById(showRequestDto.getMovieId());
                show.setMovie(movie);
            }
            if(showRequestDto.getTheatreId() != null){
                Theatre theatre = theatreService.getTheatreById(showRequestDto.getTheatreId());
                show.setTheatre(theatre);
            }
            if(showRequestDto.getFeatures() != null){
                show.setFeatures(showRequestDto.getFeatures());
            }
            if(showRequestDto.getStartTime() != null){
                show.setStartTime(showRequestDto.getStartTime());
            }
            if(showRequestDto.getEndTime() != null){
                show.setEndTime(showRequestDto.getEndTime());
            }
            return showRepository.save(show);

        }
        else{
            throw new ShowNotFoundException("Show is not existing with this id :" + id);
        }

    }
}
