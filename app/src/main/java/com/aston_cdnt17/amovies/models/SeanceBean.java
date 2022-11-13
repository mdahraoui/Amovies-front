package com.aston_cdnt17.amovies.models;

import java.util.ArrayList;

public class SeanceBean {

    private String day;
    private String date;
    private ArrayList<CinemaBean> cinemas;

    public String getDay() {
        return day;
    }

    public String getDate() {
        return date;
    }

    public ArrayList<CinemaBean> getCinema() {
        return cinemas;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setCinemas(ArrayList<CinemaBean> cinemas) {
        this.cinemas = cinemas;
    }

    public SeanceBean() {
    }

    public SeanceBean(String day, String date, ArrayList<CinemaBean> cinemas) {
        this.day = day;
        this.date = date;
        this.cinemas = cinemas;
    }
}
