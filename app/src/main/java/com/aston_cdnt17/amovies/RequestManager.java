package com.aston_cdnt17.amovies;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.aston_cdnt17.amovies.models.SeanceBean;
import com.aston_cdnt17.amovies.models.Showtime;
import com.aston_cdnt17.amovies.models.ShowtimesBean;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.Arrays;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class RequestManager {

     private static final String SERAPI_KEY = "8a6b96209fa17af5da6a8449dcf9ceba11dfd3a434cd384a25fa79b193f2f144";

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

     public static Showtime searchSeance(String filmTitle, String ville) throws Exception{

          String url = "https://serpapi.com/search.json?q=" + filmTitle + ",+theater&location=" +ville +",+France&hl=fr&gl=fr&api_key="+SERAPI_KEY;

          String json = sendGet(url);
          ShowtimesBean data = new Gson().fromJson(json, ShowtimesBean.class);

          if(data!=null){
               return data.getSeances()[0];
          }

          return null;
     }


}
