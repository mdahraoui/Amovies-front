package com.aston_cdnt17.amovies.Listeners;

import androidx.recyclerview.widget.RecyclerView;

public interface OnMovieClickListener extends RecyclerView.OnItemTouchListener {
    void onMovieClicked(String id);
}
