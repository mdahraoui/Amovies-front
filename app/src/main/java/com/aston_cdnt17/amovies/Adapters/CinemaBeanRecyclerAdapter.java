package com.aston_cdnt17.amovies.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.aston_cdnt17.amovies.SeanceViewModel;
import com.aston_cdnt17.amovies.models.CinemaBean;
import com.example.amovies.databinding.RowResultatSeancesBinding;

import java.util.ArrayList;
import java.util.List;

public class CinemaBeanRecyclerAdapter extends ListAdapter<CinemaBean, CinemaBeanRecyclerAdapter.ViewHolder> {

    private SeanceViewModel parentmodel;

    // variable qui permettra de partager les données entre le cinema et ses séances
    // Necessaire pour les "nested recyclerView"
    private RecyclerView.RecycledViewPool viewPool = new RecyclerView.RecycledViewPool();

    static class ViewHolder extends RecyclerView.ViewHolder{

        RowResultatSeancesBinding binding;


        public ViewHolder(RowResultatSeancesBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

    }

    static class Comparator extends DiffUtil.ItemCallback<CinemaBean>{
        @Override
        public boolean areItemsTheSame(@NonNull CinemaBean oldItem, @NonNull CinemaBean newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull CinemaBean oldItem, @NonNull CinemaBean newItem) {
            return oldItem.getName().equals(newItem.getName()) && oldItem.getAddress().equals(newItem.getAddress());
        }
    }


    public CinemaBeanRecyclerAdapter() {
        super(new Comparator());

    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        return new ViewHolder(RowResultatSeancesBinding.inflate(inflater));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        CinemaBean cinema = getItem(position);

        holder.binding.tvNomCinema.setText(cinema.getName());
        holder.binding.tvAdressCinema.setText(cinema.getDistance() + " -- " +cinema.getAddress());

        //Nested recyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(holder.binding.rcViewShowing.getContext(),LinearLayoutManager.HORIZONTAL,false);
        holder.binding.rcViewShowing.setLayoutManager(layoutManager);
        TimeRecyclerAdapter childAdapter = new TimeRecyclerAdapter(cinema.getHoraire());
        holder.binding.rcViewShowing.setAdapter(childAdapter);
        holder.binding.rcViewShowing.setRecycledViewPool(viewPool);

        if(!cinema.getHoraire().isEmpty()){
            childAdapter.submitList(new ArrayList<String>(cinema.getHoraire()));
        }


    }
}
