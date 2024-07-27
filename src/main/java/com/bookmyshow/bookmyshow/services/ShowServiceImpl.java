package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.dtos.ScreenRequestDto;
import com.bookmyshow.bookmyshow.dtos.ShowRequestDto;
import com.bookmyshow.bookmyshow.exceptions.ShowAlreadyExistsException;
import com.bookmyshow.bookmyshow.models.Movie;
import com.bookmyshow.bookmyshow.models.Screen;
import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.repositories.ShowRepository;
import org.springframework.stereotype.Service;

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
    public Show createShow(ShowRequestDto showRequestDto) {
        if ( showRepository.existsByScreen_Name(showRequestDto.getScreen())) {
            throw new ShowAlreadyExistsException("Show already exists with this screen");
        }

        Show show = new Show();
//        show.setStartTime(showRequestDto.getStartTime());
//        show.setEndTime(showRequestDto.getEndTime());
//        show.setFeatures(showRequestDto.getFeatures());
//        show.setMovie(movie);
//        show.setScreen(screen);
//        show.setTheatre(theatre);

        return showRepository.save(show);
    }
}
