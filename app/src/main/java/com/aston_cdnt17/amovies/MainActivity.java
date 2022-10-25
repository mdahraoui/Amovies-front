package com.aston_cdnt17.amovies;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.aston_cdnt17.amovies.Adapters.HomeRecyclerAdapter;
import com.aston_cdnt17.amovies.Listeners.OnMovieClickListener;
import com.aston_cdnt17.amovies.Listeners.OnSerachApiListener;
import com.aston_cdnt17.amovies.models.SearchApiResponse;
import com.example.amovies.R;

public class MainActivity extends AppCompatActivity implements OnMovieClickListener {

    SearchView search_view;
    RecyclerView recycler_view_home;
    HomeRecyclerAdapter adapter;
    RequestManager manager;
    ProgressDialog dialog;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        search_view = findViewById(R.id.search_view);
        recycler_view_home = findViewById(R.id.recycler_view_home);
        manager = new RequestManager(this);
        dialog = new ProgressDialog(this);

        search_view.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                dialog.setTitle("Please wait...");
                dialog.show();
                manager.searchMovies(listener, query);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

    }

    private final OnSerachApiListener listener = new OnSerachApiListener() {
        @Override
        public void onResponse(SearchApiResponse response) {
            dialog.dismiss();
            if (response==null){
                Toast.makeText(MainActivity.this, "No data available", Toast.LENGTH_LONG).show();
                return;
            }
            showResult(response);
        }

        @Override
        public void onError(String message) {
            dialog.dismiss();
            Toast.makeText(MainActivity.this,"an error occurred",Toast.LENGTH_LONG).show();

        }
    };


    private void showResult(SearchApiResponse response) {
        recycler_view_home.setHasFixedSize(true);
        recycler_view_home.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        adapter = new HomeRecyclerAdapter(this, response.getTitle(), this);
        recycler_view_home.setAdapter(adapter);
    }


    @Override
    public void onMovieClicked(String id) {
        Toast.makeText(MainActivity.this, id, Toast.LENGTH_LONG).show();

    }
}