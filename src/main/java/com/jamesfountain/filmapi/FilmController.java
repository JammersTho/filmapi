package com.jamesfountain.filmapi;

import com.jamesfountain.filmapi.model.Film;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("films")
public class FilmController {

    @Autowired FilmRepository filmRepo;

    @GetMapping(value = "/{id}", produces = "application/json")
    public Film getFilmById(@PathVariable int id) {

        Optional<Film> film = filmRepo.findById((long) id);

        if (film.isPresent()) {
            return film.get();
        } else {
            throw new FilmNotFoundException();
        }

    }

    @GetMapping(value = "/category/{id}", produces = "application/json")
    public List<Film> getRandomFilmByCategory(@PathVariable int category) {

        List<Film> films = filmRepo.fetchByCategory(category);

        if (!films.isEmpty()) {
            return films;
        } else {
            throw new FilmNotFoundException();
        }

    }
}
