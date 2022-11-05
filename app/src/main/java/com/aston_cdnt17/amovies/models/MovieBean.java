package com.aston_cdnt17.amovies.models;

import java.util.List;

public class MovieBean {

    public int idMovies;
    public String nom ;
    public String description ;
    public boolean adulte ;
    public String posterPath ;
    public float note ;
    public int popularite ;

    public String director ;
    public String[] genres ;

    public  String[] actors;

    public MovieBean() {
    }

    public int getIdMovies() {
        return idMovies;
    }

    public void setIdMovies(int idMovies) {
        idMovies = idMovies;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        description = description;
    }

    public boolean isAdulte() {
        return adulte;
    }

    public void setAdulte(boolean adulte) {
        adulte = adulte;
    }

    public String getPosterPath() {
        return posterPath;
    }

    public void setPosterPath(String posterPath) {
        posterPath = posterPath;
    }

    public float getNote() {
        return note;
    }

    public void setNote(float note) {
        note = note;
    }

    public int getPopularite() {
        return popularite;
    }

    public void setPopularite(int popularite) {
        popularite = popularite;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        director = director;
    }

    public String[] getGenres() {
        return genres;
    }

    public void setGenres(String[] genres) {
        genres = genres;
    }

    public String[] getActors() {
        return actors;
    }

    public void setActors(String[] actors) {
        actors = actors;
    }
}
