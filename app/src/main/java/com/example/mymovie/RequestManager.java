package com.example.mymovie;

import android.content.Context;
import android.widget.Toast;

import com.example.mymovie.Listeners.OnSerachApiListener;
import com.example.mymovie.models.SearchApiResponse;

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
             .baseUrl("https://dbm.p.rapidapi.com")
             .addConverterFactory(GsonConverterFactory.create())
             .build();

     public RequestManager(Context context) {
          this.context = context;
     }

     public void searchMovies(OnSerachApiListener listener, String movie_name) {
          getMovies getMovies = reftrofit.create(RequestManager.getMovies.class);
          Call<SearchApiResponse> call = getMovies.callMovies(movie_name);

          call.enqueue(new Callback<SearchApiResponse>() {
               @Override
               public void onResponse(Call<SearchApiResponse> call, Response<SearchApiResponse> response) {
                    if (!response.isSuccessful()) {
                         Toast.makeText(context, "Couldn't fetch Data!", Toast.LENGTH_LONG );
                         return;
                    }
                    listener.onResponse(response.body());
               }

               @Override
               public void onFailure(Call<SearchApiResponse> call, Throwable t) {
                    listener.onError(t.getMessage());

               }
          });
     }


     public interface getMovies {
          @Headers({
                  "Accept: application/json",
                  "x-rapidapi-host: dbm.p.rapidapi.com",
                  "x-rapidapi-host: 182388e94fmsh44160494f4598f0p1d81b5jsnff34339873c9",
          })
          @GET("listings")
          Call<SearchApiResponse> callMovies(
                  @Path("movie_name") String movie_name
          );
     }
}
