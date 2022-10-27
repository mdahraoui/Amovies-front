package com.aston_cdnt17.amovies.models;

import java.util.List;

public class MovieBean {

    public int IdMovies;
    public String Nom ;
    public String Description ;
    public boolean Adulte ;
    public String PosterPath ;
    public float Note ;
    public int Popularite ;

    public String Director ;
    public List<String> Genres ;

    public  List<String> Actors;

    public MovieBean() {
    }

    public int getIdMovies() {
        return IdMovies;
    }

    public void setIdMovies(int idMovies) {
        IdMovies = idMovies;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public boolean isAdulte() {
        return Adulte;
    }

    public void setAdulte(boolean adulte) {
        Adulte = adulte;
    }

    public String getPosterPath() {
        return PosterPath;
    }

    public void setPosterPath(String posterPath) {
        PosterPath = posterPath;
    }

    public float getNote() {
        return Note;
    }

    public void setNote(float note) {
        Note = note;
    }

    public int getPopularite() {
        return Popularite;
    }

    public void setPopularite(int popularite) {
        Popularite = popularite;
    }

    public String getDirector() {
        return Director;
    }

    public void setDirector(String director) {
        Director = director;
    }

    public List<String> getGenres() {
        return Genres;
    }

    public void setGenres(List<String> genres) {
        Genres = genres;
    }

    public List<String> getActors() {
        return Actors;
    }

    public void setActors(List<String> actors) {
        Actors = actors;
    }
}
