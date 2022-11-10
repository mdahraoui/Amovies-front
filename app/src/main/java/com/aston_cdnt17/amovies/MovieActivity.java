package com.aston_cdnt17.amovies;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.aston_cdnt17.amovies.models.MovieBean;
import com.example.amovies.R;
import com.example.amovies.databinding.ActivityMovieBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

public class MovieActivity extends AppCompatActivity {

    ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMovieBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        final Intent intent = getIntent();
        String obj = intent.getStringExtra("movie");
        MovieBean movie = new Gson().fromJson(obj,MovieBean.class);

        if(movie !=null){
            binding.tvTitre.setText(movie.getNom());
            binding.tvRealisateur.setText("De "+movie.getDirector());
            binding.tvDateDuree.setText("Note: "+movie.getNote() +" | Popularite : "+movie.getPopularite());
            binding.tvDescription.setText(movie.getDescription());
            binding.tvActeurs.setText("Avec " + String.join(",",movie.getActors()) +"...");

            if(movie.getPosterPath()!=null){
                Picasso.get().load(Uri.parse("https://image.tmdb.org/t/p/w400/"+movie.getPosterPath())).into(binding.imageView);
            }
        }


    }
}