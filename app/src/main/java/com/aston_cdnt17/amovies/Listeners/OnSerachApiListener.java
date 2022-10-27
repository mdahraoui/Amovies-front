package com.aston_cdnt17.amovies.Listeners;

import com.aston_cdnt17.amovies.models.MovieBean;

import java.util.ArrayList;

public interface OnSerachApiListener {

    void onResponse(ArrayList<MovieBean> response);
    void onError(String message);

}
