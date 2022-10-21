package com.example.mymovie;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.mymovie.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {

    ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
    }
}