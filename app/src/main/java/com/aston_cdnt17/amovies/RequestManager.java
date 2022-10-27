package com.aston_cdnt17.amovies;

import android.content.Context;
import android.widget.Toast;

import com.aston_cdnt17.amovies.Listeners.OnSerachApiListener;
import com.aston_cdnt17.amovies.models.MovieBean;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public class RequestManager {

     Context context;
     Retrofit reftrofit = new Retrofit.Builder()
             .baseUrl("https://192.168.1.254:7125/Movies")
             .addConverterFactory(GsonConverterFactory.create())
             .build();

     public RequestManager(Context context) {
          this.context = context;
     }

     public void searchMovies(OnSerachApiListener listener, String movie_name) {
          getMovies getMovies = reftrofit.create(RequestManager.getMovies.class);
          Call<ArrayList<MovieBean>> call = getMovies.callMovies(movie_name);

          call.enqueue(new Callback<ArrayList<MovieBean>>() {
               @Override
               public void onResponse(Call<ArrayList<MovieBean>> call, Response<ArrayList<MovieBean>> response) {
                    if (!response.isSuccessful()) {
                         Toast.makeText(context, "Couldn't fetch Data!", Toast.LENGTH_LONG );
                         return;
                    }
                    listener.onResponse(response.body());
               }

               @Override
               public void onFailure(Call<ArrayList<MovieBean>> call, Throwable t) {
                    listener.onError(t.getMessage());

               }
          });
     }


     public interface getMovies {
          @Headers({
                  "Accept: application/json"
          })
          @GET()
          Call<ArrayList<MovieBean>> callMovies(
                  @Path("movie_name") String movie_name
          );
     }
}
