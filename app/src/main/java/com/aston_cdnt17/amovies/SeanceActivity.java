package com.aston_cdnt17.amovies;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;

import com.aston_cdnt17.amovies.Adapters.CinemaBeanRecyclerAdapter;
import com.aston_cdnt17.amovies.models.CinemaBean;
import com.example.amovies.databinding.ActivityMovieBinding;
import com.example.amovies.databinding.ActivitySeanceBinding;

import java.util.ArrayList;
import java.util.Arrays;

public class SeanceActivity extends AppCompatActivity {

    private ActivitySeanceBinding binding;

    private SeanceViewModel model;

    private CinemaBeanRecyclerAdapter adapter = new CinemaBeanRecyclerAdapter();

    @Override
    protected void onStart() {
        super.onStart();
        //Récupération du titre de film
        final Intent intent = getIntent();
        String title = intent.getStringExtra("title");
        // Récupérer la location
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION)
                == PackageManager.PERMISSION_GRANTED) {

            Location location = LocationUtils.getLastKnownLocation(this);
            if(location != null){

                model.loadSeances(title, location, this);
            }

        }else{

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, 0);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivitySeanceBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        model = new ViewModelProvider(this).get(SeanceViewModel.class);

        binding.rcCinema.setAdapter(adapter);
        binding.rcCinema.setLayoutManager(new GridLayoutManager(this,1));


        model.séances.observe(this, séances ->{
            if(séances != null ){
                if(séances.getCinema()!=null || séances.getCinema().isEmpty()){
                    adapter.submitList(new ArrayList<CinemaBean>(séances.getCinema()));
                    binding.tvToday.setText(séances.getDay()+" - "+séances.getDate());
                }
            }else {
                binding.tvToday.setText("Today");
                binding.tvNoDispo.setVisibility(View.VISIBLE);
                binding.tvNoDispo.setText("No show available");
            }
        });

    }
}