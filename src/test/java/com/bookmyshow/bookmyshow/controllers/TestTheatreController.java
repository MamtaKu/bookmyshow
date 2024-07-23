package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.exceptions.TheatreNotFoundException;
import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import com.bookmyshow.bookmyshow.services.TheatreService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class TestTheatreController {
    @Mock
    private TheatreService theatreService;
    @InjectMocks
    private TheatreController theatreController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetTheatreById(){
        Theatre theatre = new Theatre();
        theatre.setId(1L);
        when(theatreService.getTheatreById(1L)).thenReturn(theatre);
        assertEquals(theatre, theatreController.getTheaterById(1L));
    }

    @Test
    public void testGetAllTheatres(){
        Theatre theatre1 = new Theatre();
        theatre1.setId(1L);
        Theatre theatre2 = new Theatre();
        theatre2.setId(2L);

        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatre1);
        theatreList.add(theatre2);

        when(theatreService.getAllTheatres()).thenReturn(theatreList);
        assertEquals(theatreList, theatreController.getAllTheaters());
    }


    @Test
    public void testGetTheatresByCity(){
        Theatre theatre = new Theatre();

        theatre.setId(1L);

        Theatre theatre1 = new Theatre();
        theatre1.setId(2L);

        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatre);
        theatreList.add(theatre1);


        when(theatreService.getTheatresByCity("City Name")).thenReturn(theatreList);
        assertEquals(theatreList,theatreController.getTheatresByCity("City Name"));

    }
    @Test
    public void testGetTheatresByCityAndMovie(){
        Theatre theatre = new Theatre();

        theatre.setId(1L);

        Theatre theatre1 = new Theatre();
        theatre1.setId(2L);

        List<Theatre> theatreList = new ArrayList<>();
        theatreList.add(theatre);
        theatreList.add(theatre1);

        when(theatreService.getTheatresByCityAndMovie("CityName", "MovieName")).thenReturn(theatreList);
        assertEquals(theatreList, theatreController.getTheatresByCityAndMovie("CityName", "MovieName"));

    }

    @Test
    public void testCreateTheatre(){
        Theatre theatre = new Theatre();
        theatre.setId(1L);
        theatre.setName("Theatre Name");
        Theatre createdTheatre = new Theatre();
        createdTheatre.setId(theatre.getId());
        createdTheatre.setName(theatre.getName());

        when(theatreService.createTheatre(theatre)).thenReturn(createdTheatre);
        assertEquals(HttpStatus.CREATED, theatreController.createTheatre(theatre).getStatusCode());
        assertEquals(createdTheatre, theatreController.createTheatre(theatre).getBody());

    }

    @Test
    public void testUpdateTheatre() throws TheatreNotFoundException {
        Theatre theatre = new Theatre();
        theatre.setId(1L);
        theatre.setName("Updated Theatre");

        Theatre updatedTheatre  = new Theatre();
        updatedTheatre.setId(1L);
        updatedTheatre.setName("Updated Theatre");

        when(theatreService.updateTheatre(1L,theatre)).thenReturn(updatedTheatre);
        assertEquals(HttpStatus.OK, theatreController.updateTheatre(1L, theatre).getStatusCode());
        assertEquals(updatedTheatre, theatreController.updateTheatre(1L, theatre).getBody());
    }


    @Test
    public void testDeleteTheatre() throws TheatreNotFoundException {
        doNothing().when(theatreService).deleteTheatre(1L);
        assertEquals(HttpStatus.NO_CONTENT, theatreController.deleteTheatre(1L).getStatusCode());
    }

    @Test
    public void testPatchTheatre() throws TheatreNotFoundException {
        Theatre theatre = new Theatre();
        theatre.setName("Patched Theatre");
        Theatre patchedTheatre = new Theatre();
        patchedTheatre.setId(1L);
        patchedTheatre.setName("Patched Theatre");
        when(theatreService.patchTheatre(1L, theatre)).thenReturn(patchedTheatre);

        ResponseEntity<Theatre> response = theatreController.patchTheatre(1L, theatre);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patchedTheatre, response.getBody());
    }
}
