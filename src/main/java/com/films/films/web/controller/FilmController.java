package com.films.films.web.controller;

import com.films.films.dao.FilmDao;
import com.films.films.exceptions.NotFoundException;
import com.films.films.model.Film;
import com.films.films.model.Type;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@CrossOrigin(origins = "*")
@Api( description="API CRUD sur films")
@RestController
public class FilmController {

    @Autowired
    private FilmDao filmDao;


    @ApiOperation(value = "Recupère la liste de tous les films")
    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value="/films", method= RequestMethod.GET)
    public List<Film> filmsList() {
        return filmDao.findAll();
    }

    @ApiOperation(value = "Récupère un film grâce à son ID")
    @CrossOrigin(origins = "http://localhost:9090")
    @GetMapping(value = "/films/{id}")
    public Film getFilmById(@PathVariable int id) {
        Film film = filmDao.findById(id);
        if(film==null){
            throw new NotFoundException("Film non existant");
        }
        return film;
    }

    @ApiOperation(value = "Ajouter un film")
    @PostMapping(value = "/films")
    public ResponseEntity<Void> addFilm(@RequestBody Film film) {

    Film filmAdded =  filmDao.save(film);

        if (filmAdded == null)
            return ResponseEntity.noContent().build();

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(filmAdded.getId())
                .toUri();

       // return ResponseEntity.created(location).build();
        return null;
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @RequestMapping(value="/films", method= RequestMethod.PUT)
    public void updateFilm(@RequestBody Film film) {
        System.out.println("+++++++ UPDATE");
        System.out.println(film.toString());
        System.out.println("+++++++ UPDATE");
        filmDao.save(film);
    }

    @CrossOrigin(origins = "http://localhost:9090")
    @DeleteMapping (value = "/films/{id}")
    public void deleteFilm(@PathVariable int id) {
        filmDao.deleteById(id);
    }


}
