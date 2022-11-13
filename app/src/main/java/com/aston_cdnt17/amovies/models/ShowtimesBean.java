package com.aston_cdnt17.amovies.models;

import com.google.gson.annotations.SerializedName;

public class ShowtimesBean {

    @SerializedName("showtimes")
    private Showtime[] seances;

    public Showtime[] getSeances() {
        return seances;
    }
}
