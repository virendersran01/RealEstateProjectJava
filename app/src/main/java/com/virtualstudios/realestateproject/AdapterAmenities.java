package com.virtualstudios.realestateproject;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class AdapterAmenities extends RecyclerView.Adapter<AdapterAmenities.ViewHolder> {
    private List<String> amenities;

    public AdapterAmenities(List<String> amenities) {
        this.amenities = amenities;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_amenities, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(amenities.get(position));
    }

    @Override
    public int getItemCount() {
        return amenities.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView textView;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           textView = itemView.findViewById(R.id.textValue);
        }

        public void setData(String value){
            textView.setText(value);
        }
    }
}