package com.aston_cdnt17.amovies.models;

import java.util.List;

public class SearchApiResponse {


    String id = "";
    List<SearchApiResponse> title = null;
    String description = "";
    String image = "";
    String rating = "";
    String longitud = "";
    String latitud = "";



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<SearchApiResponse> getTitle() {
        return title;
    }

    public void setTitle(List<SearchApiResponse> title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
}
