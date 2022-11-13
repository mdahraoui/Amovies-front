package com.aston_cdnt17.amovies.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.amovies.databinding.RowSeancesTimeBinding;

import java.util.ArrayList;
import java.util.Locale;

public class TimeRecyclerAdapter extends ListAdapter<String, TimeRecyclerAdapter.ViewHolder> {

    private ArrayList<String> times;

    public TimeRecyclerAdapter(ArrayList<String> timings) {
        super(new Comparator());
        this.times = timings;
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
         RowSeancesTimeBinding binding ;

        public ViewHolder( RowSeancesTimeBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    static class Comparator extends DiffUtil.ItemCallback<String>{
        @Override
        public boolean areContentsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.toLowerCase(Locale.ROOT).equals(newItem.toLowerCase(Locale.ROOT));
        }

        @Override
        public boolean areItemsTheSame(@NonNull String oldItem, @NonNull String newItem) {
            return oldItem.equals(newItem);
        }
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String timing = this.times.get(position);
        holder.binding.textView.setText(timing);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater laInflater  = LayoutInflater.from(parent.getContext());
        return new ViewHolder(RowSeancesTimeBinding.inflate(laInflater));
    }
}
