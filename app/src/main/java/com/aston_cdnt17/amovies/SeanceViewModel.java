package com.aston_cdnt17.amovies;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.aston_cdnt17.amovies.models.CinemaBean;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.aston_cdnt17.amovies.models.SeanceBean;
import com.aston_cdnt17.amovies.models.Showing;
import com.aston_cdnt17.amovies.models.Showtime;
import com.aston_cdnt17.amovies.models.Theaters;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class SeanceViewModel extends ViewModel {

    MutableLiveData<SeanceBean> séances = new MutableLiveData<>();

    MutableLiveData<String> time = new MutableLiveData<>();

    public MutableLiveData<SeanceBean> getSéances() {
        return séances;
    }

    public MutableLiveData<String> getTime() {
        return time;
    }

    public void loadSeances(String title, Location location, Context context){
        new Thread(()->{
            try{
                String cityName="Paris";
                //Trouver la ville
                Geocoder geocoder = new Geocoder(context, Locale.getDefault());
                List<Address> list = geocoder.getFromLocation(location.getLatitude(), location.getLongitude(),1);

                if(list!=null){
                    cityName = list.get(0).getLocality();
                }
                //Récupérer les séances
                Showtime todayShow = RequestManager.searchSeance(title, cityName);
                SeanceBean data = ConvertToSeanceBean(todayShow);
                séances.postValue(data);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }).start();
    }


    private SeanceBean ConvertToSeanceBean (Showtime showtime){

        ArrayList<CinemaBean> cinemas = new ArrayList<>();
        for (Theaters theater:showtime.getTheaters()) {
            cinemas.add(ConvertToCinemaBean(theater));
        }
        return new SeanceBean(showtime.getDay(), showtime.getDate(), cinemas);
    }

    private CinemaBean ConvertToCinemaBean (Theaters theater){

        ArrayList<String> shows = new ArrayList<String>();
        for (Showing show : theater.getShowing()) {
            if(show!=null && (show.getType()==null  || show.getType().equals("Standard"))){
                shows.addAll(Arrays.asList(show.getTime()));
            }
        }
        return new CinemaBean(theater.getName(), theater.getDistance(), theater.getAddress(), shows);

    }
}
