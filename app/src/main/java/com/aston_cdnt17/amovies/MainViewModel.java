package com.aston_cdnt17.amovies;


import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aston_cdnt17.amovies.models.MovieBean;

import java.util.ArrayList;

public class MainViewModel extends ViewModel {

    MutableLiveData<ArrayList<MovieBean>> movies = new MutableLiveData<>();

    public MutableLiveData<ArrayList<MovieBean>> getMovies() {
        return movies;
    }

    public void loadMovies(){
        new Thread(()->{
            try{
                ArrayList<MovieBean> all = RequestManager.searchMovies();
                ArrayList<MovieBean> data = new ArrayList<>();
                data.addAll(all);
                movies.postValue(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }
}
