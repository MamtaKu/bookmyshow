package com.bookmyshow.bookmyshow.services;

import com.bookmyshow.bookmyshow.models.Show;
import com.bookmyshow.bookmyshow.repositories.ShowRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShowServiceImpl implements ShowService{

    private final ShowRepository showRepository;

    public ShowServiceImpl(ShowRepository showRepository) {
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
}
