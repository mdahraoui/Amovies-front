package com.aston_cdnt17.amovies;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.amovies.R;
import com.example.amovies.databinding.ActivityMovieBinding;

public class MovieActivity extends AppCompatActivity {

    ActivityMovieBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_movie);
    }
}