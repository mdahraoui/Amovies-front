package com.aston_cdnt17.amovies;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestManager {

     public static String sendGet(String url) throws Exception {

          System.out.println("url: " + url);

          OkHttpClient client = new OkHttpClient();

          Request request = new Request.Builder().url(url).build();

          try {
               Response response = client.newCall(request).execute();
               if (!response.isSuccessful()) {
                    throw new Exception("error occured : " + response);
               }

               return response.body().string();
          } catch (Exception e) {
               e.printStackTrace();
               return e.getMessage();
          }
     }

     public static ArrayList<MovieBean> searchMovies () throws Exception{
          String json = sendGet("https://astonamovies.azurewebsites.net/Movies");
          MovieBean[] data = new Gson().fromJson(json, MovieBean[].class);

          ArrayList<MovieBean> movies = new ArrayList<>();
          movies.addAll(Arrays.asList(data));

          return movies;
     }
}
