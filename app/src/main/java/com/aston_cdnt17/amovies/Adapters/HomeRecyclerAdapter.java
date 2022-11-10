package com.aston_cdnt17.amovies.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aston_cdnt17.amovies.MainViewModel;
import com.aston_cdnt17.amovies.MovieActivity;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.example.amovies.R;
import com.example.amovies.databinding.HomeMoviesListBinding;
import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import java.util.Comparator;

public class HomeRecyclerAdapter extends ListAdapter<MovieBean, HomeRecyclerAdapter.ViewHolder> {

    private MainViewModel _parentViewModel;

    public MainViewModel get_parentViewModel() {
        return _parentViewModel;
    }

    public void set_parentViewModel(MainViewModel _parentViewModel) {
        this._parentViewModel = _parentViewModel;
    }

    public HomeRecyclerAdapter() {
        super(new Comparator());
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());

        return new ViewHolder(HomeMoviesListBinding.inflate(inflater), parent.getContext());
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        MovieBean movie = getItem(position);


        //Poster
        if(movie.getPosterPath().isEmpty()){
            holder.binding.imageViewPoster.setImageResource(R.mipmap.ic_launcher_round);
        }else{
            Picasso.get().load(Uri.parse("https://image.tmdb.org/t/p/w200/"+movie.getPosterPath())).into(holder.binding.imageViewPoster);
            holder.binding.imageViewPoster.setOnClickListener(v -> {
                System.out.println("you're inside onclickListener");
                _parentViewModel.clickMovie(movie);
            });
        }

        //Titre
        if(movie.getNom().isEmpty()){
            holder.binding.textViewMovie.setText("");
        }else{
            holder.binding.textViewMovie.setText(movie.getNom());
        }
    }


    static class ViewHolder extends RecyclerView.ViewHolder {

    HomeMoviesListBinding binding;
    Context parentContext;

        public ViewHolder(HomeMoviesListBinding binding, Context context) {
            super(binding.getRoot());
            this.binding = binding;
            this.parentContext = context;
        }


    }

    static class Comparator extends DiffUtil.ItemCallback<MovieBean>{
        @Override
        public boolean areItemsTheSame(@NonNull MovieBean oldItem, @NonNull MovieBean newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull MovieBean oldItem, @NonNull MovieBean newItem) {
            return oldItem.nom.equals(newItem.nom) && oldItem.director.equals(newItem.director) && oldItem.description.equals(newItem.description);
        }
    }

    public MovieBean getMovie(int position){
        return getItem(position);
    }
}
