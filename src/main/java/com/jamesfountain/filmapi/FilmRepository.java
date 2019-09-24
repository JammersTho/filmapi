package com.jamesfountain.filmapi;

import com.jamesfountain.filmapi.model.Film;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FilmRepository extends CrudRepository<Film, Long> {

    @Query(value = "SELECT film_id, title, description, film.length, rating FROM Film f " +
            "INNER JOIN film_category ON f.film_id=film_category.film_id WHERE film_category.category_id =:categoryId")
    List<Film> fetchByCategory(@Param("category") int categoryId);

}
