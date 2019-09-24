package com.jamesfountain.filmapi.model;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@Entity
public class Film {

    @Id
    private Long filmId;
    private String title;
    private String description;
    private int length;
    private String rating;

}
