package com.jamesfountain.filmapi;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Film not found")
public class FilmNotFoundException extends RuntimeException {
}
