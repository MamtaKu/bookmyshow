package com.bookmyshow.bookmyshow.repositories;

import com.bookmyshow.bookmyshow.models.City;
import com.bookmyshow.bookmyshow.models.Theatre;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TheatreRepository extends JpaRepository<Theatre, Long> {
    @Override
    List<Theatre> findAll();

    List<Theatre> findByCity_name(String name);
}