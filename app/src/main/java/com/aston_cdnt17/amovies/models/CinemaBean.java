package com.aston_cdnt17.amovies.models;

import java.util.ArrayList;

public class CinemaBean {

    private String name;
    private String distance;
    private String address;

    private ArrayList<String> horaire;

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public String getAddress() {
        return address;
    }

    public ArrayList<String> getHoraire() {
        return horaire;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHoraire(ArrayList<String> horaire) {
        this.horaire = horaire;
    }

    public CinemaBean() {
    }

    public CinemaBean(String name, String distance, String address, ArrayList<String> horaire) {
        this.name = name;
        this.distance = distance;
        this.address = address;
        this.horaire = horaire;
    }
}
