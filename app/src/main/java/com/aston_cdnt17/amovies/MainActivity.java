package com.aston_cdnt17.amovies;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aston_cdnt17.amovies.Adapters.HomeRecyclerAdapter;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.example.amovies.databinding.ActivityMainBinding;
import com.google.gson.Gson;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter = new HomeRecyclerAdapter();
//    RequestManager manager;
//    ProgressDialog dialog;
    MainViewModel model;


    @Override
    protected void onStart() {
        super.onStart();
        model.loadMovies();

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        model = new ViewModelProvider(this).get(MainViewModel.class);
        search_view = binding.searchView;
        recycler_view_home = binding.recyclerViewHome;

        recycler_view_home.setAdapter(adapter);
        recycler_view_home.setLayoutManager(new GridLayoutManager(this, 2));


        adapter.set_parentViewModel(model);


        model.movies.observe(this, movies ->{
            if(movies != null){
                adapter.submitList(new ArrayList<MovieBean>(movies));
            }
        });


        model.movieClicked.observe(this,m->{
            if(m!=null){
                Intent movieIntent = new Intent(this, MovieActivity.class);
                String mToString = new Gson().toJson(m);
                movieIntent.putExtra("movie", mToString);
                startActivity(movieIntent);
            }
        });


        //dialog = new ProgressDialog(this);

        // To look for 1 movie (?)
//        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                dialog.setTitle("Please wait...");
//                dialog.show();
//                try {
//                    listener.onResponse(RequestManager.searchMovies());
//                } catch (Exception e) {
//                    e.printStackTrace();
//                }
//                return true;
//            }
//
//            @Override
//            public boolean onQueryTextChange(String newText) {
//                return false;
//            }
//        });

    }

//    private final OnSerachApiListener listener = new OnSerachApiListener() {
//        @Override
//        public void onResponse(ArrayList<MovieBean> response) {
//            dialog.dismiss();
//            if (response==null){
//                Toast.makeText(MainActivity.this, "No data available", Toast.LENGTH_LONG).show();
//                return;
//            }
//            showResult(response);
//        }
//
//        @Override
//        public void onError(String message) {
//            dialog.dismiss();
//            Toast.makeText(MainActivity.this,"an error occurred",Toast.LENGTH_LONG).show();
//
//        }
//    };


//    private void showResult(ArrayList<MovieBean> response) {
//        recycler_view_home.setHasFixedSize(true);
//        recycler_view_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
//        adapter = new HomeRecyclerAdapter(this, response, this);
//        recycler_view_home.setAdapter(adapter);
//    }

//    @Override
//    public void onMovieClicked(String id) {
//        Toast.makeText(MainActivity.this, id, Toast.LENGTH_LONG).show();
//
//    }
}