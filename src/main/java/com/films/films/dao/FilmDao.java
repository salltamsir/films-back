package com.films.films.dao;

import com.films.films.model.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmDao extends JpaRepository<Film, Integer> {

    Film findById(int id);

    @Override
    Film save(Film film);


    Film deleteFilmById(int id);
}


