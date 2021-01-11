package com.virtualstudios.realestateproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

public class ListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        setupPropertyListing();
        findViewById(R.id.imageBack).setOnClickListener(v -> onBackPressed());
    }

    private void setupPropertyListing() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPropertyListing);
        recyclerView.setAdapter(new AdapterPropertyListing(10));
    }
}