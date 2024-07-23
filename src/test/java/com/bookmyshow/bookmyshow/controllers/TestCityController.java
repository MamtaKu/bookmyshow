package com.bookmyshow.bookmyshow.controllers;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.services.CityService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;

public class TestCityController {

    @Mock
    private CityService cityService;

    @InjectMocks
    private CityController cityController;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testGetCityById(){
        City city = new City();
            city.setId(1L);
            city.setName("Test City");
        when(cityService.getCityById(1L)) .thenReturn(city);
        assertEquals(1L,cityController.getCityById(1L).getId());
        assertEquals("Test City", cityController.getCityById(1L).getName());

    }

    @Test
    public void testGetAllCity(){
        City city1 = new City();
        city1.setId(1L);
        city1.setName("Test City 1");

        City city2 = new City();
        city2.setId(2L);
        city2.setName("Test City 2");

        List<City> cityList = new ArrayList<>();

        cityList.add(city1);
        cityList.add(city2);

        when(cityService.getAllCity()).thenReturn(cityList);
        assertEquals(2,cityController.getAllCity().size());
        assertEquals("Test City 1", cityController.getAllCity().get(0).getName());
        assertEquals("Test City 2", cityController.getAllCity().get(1).getName());

    }


    @Test
    public void testCreateCity(){
        City city = new City();
        city.setId(1L);
        city.setName("TestCity");


        City createdCity = new City();
        createdCity.setId(city.getId());
        createdCity.setName(city.getName());

        when(cityService.createCity(city)).thenReturn(createdCity);
        ResponseEntity<City> response = cityController.createCity(city);
        assertNotNull(response);
        assertEquals(HttpStatus.CREATED, response.getStatusCode());
        assertEquals(1L, response.getBody().getId());
        assertEquals("TestCity", response.getBody().getName());
    }

    @Test
    public void testUpdateCity() {
        City city = new City();
        city.setName("Updated City");
        City updatedCity = new City();
        updatedCity.setId(1L);
        updatedCity.setName("Updated City");
        when(cityService.updateCity(1L, city)).thenReturn(updatedCity);

        ResponseEntity<City> response = cityController.updateCity(1L, city);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(updatedCity, response.getBody());
    }

    @Test
    public void testPatchCity() {
        City city = new City();
        city.setName("Patched City");
        City patchedCity = new City();
        patchedCity.setId(1L);
        patchedCity.setName("Patched City");
        when(cityService.patchCity(1L, city)).thenReturn(patchedCity);

        ResponseEntity<City> response = cityController.patchCity(1L, city);
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(patchedCity, response.getBody());
    }
    @Test
    public void testDeleteCity() {
        doNothing().when(cityService).deleteCity(1L);

        ResponseEntity<Void> response = cityController.deleteCity(1L);
        assertEquals(HttpStatus.NO_CONTENT, response.getStatusCode());

    }



}
