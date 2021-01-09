package com.virtualstudios.realestateproject;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textview.MaterialTextView;

import java.util.List;

public class AdapterDetail extends RecyclerView.Adapter<AdapterDetail.ViewHolder> {
    private List<DetailActivity.DetailModel> list;

    public AdapterDetail(List<DetailActivity.DetailModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_detail, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.setData(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private MaterialTextView textHeader, textValue;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            textHeader = itemView.findViewById(R.id.textHeader);
            textValue = itemView.findViewById(R.id.textValue);
        }

        public void setData(DetailActivity.DetailModel model){
            textHeader.setText(model.getHeader());
            textValue.setText(model.getValue());
        }
    }
}