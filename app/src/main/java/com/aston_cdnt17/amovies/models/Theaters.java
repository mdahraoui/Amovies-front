package com.aston_cdnt17.amovies.models;

public class Theaters {

    private String name;
    private String distance;
    private String address;
    private Showing[] showing;

    public String getName() {
        return name;
    }

    public String getDistance() {
        return distance;
    }

    public String getAddress() {
        return address;
    }

    public Showing[] getShowing() {
        return showing;
    }
}
