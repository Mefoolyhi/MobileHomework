package com.example.finalproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class RVAdapter extends RecyclerView.Adapter<RVAdapter.ViewHolder> {

    private List<NameItem> localDataSet;

    public RVAdapter(List<NameItem> dataSet) {
        localDataSet = dataSet;
    }

    public void addItem(NameItem item) {
        localDataSet.add(item);
        notifyItemInserted(localDataSet.size() - 1);
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.name_item, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(localDataSet.get(position));
    }

    @Override
    public int getItemCount() {
        return localDataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private final View binding;

        public ViewHolder(@NonNull View view) {
            super(view);

            binding = view;
        }

        public void bind(NameItem item) {
            ImageView image = binding.findViewById(R.id.image);
            TextView name = binding.findViewById(R.id.name_text_view);

            name.setText(item.name);

            Glide
                    .with(binding)
                    .load(item.imageUrl)
                    .centerCrop()
                    .into(image);
        }
    }
}
