package com.aston_cdnt17.amovies.Adapters;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.aston_cdnt17.amovies.Listeners.OnMovieClickListener;
import com.aston_cdnt17.amovies.models.MovieBean;
import com.example.amovies.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class HomeRecyclerAdapter extends RecyclerView.Adapter<HomeViewHolder> {
Context context;
List<MovieBean> list;
OnMovieClickListener listener;

    public HomeRecyclerAdapter(Context context, List<MovieBean> list, OnMovieClickListener listener) {
        this.context = context;
        this.list = list;
        this.listener = listener;
    }

    @NonNull
    @Override
    public HomeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new HomeViewHolder(LayoutInflater.from(context).inflate(R.layout.home_movies_list, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull HomeViewHolder holder, int position) {
        holder.textView_movie.setText((CharSequence) list.get(position).getNom());
        Picasso.get().load(Uri.parse("https://image.tmdb.org/t/p/w200/"+list.get(position).getPosterPath())).into(holder.imageView_poster);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}

class HomeViewHolder extends RecyclerView.ViewHolder {

    ImageView imageView_poster;
    TextView textView_movie;
    CardView home_container;

    public HomeViewHolder(@NonNull View itemView) {
        super(itemView);
        imageView_poster = itemView.findViewById(R.id.imageView_poster);
        textView_movie = itemView.findViewById(R.id.textView_movie);
        home_container = itemView.findViewById(R.id.home_container);
    }
}
