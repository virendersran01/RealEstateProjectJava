package com.virtualstudios.realestateproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        setupDetailView();
        setupIndoorOutdoorAmenities();
        findViewById(R.id.imageBack).setOnClickListener(v -> onBackPressed());
    }


    private void setupDetailView(){
        RecyclerView recyclerViewDetails = findViewById(R.id.recyclerViewDetails);
        List<DetailModel> detailsList = new ArrayList<>();
        detailsList.add(new DetailModel("Purpose", "Sale"));
        detailsList.add(new DetailModel("Type", "House"));
        detailsList.add(new DetailModel("Country", "India"));
        detailsList.add(new DetailModel("City", "Ludhiana"));
        detailsList.add(new DetailModel("Area", "More than 100m2"));
        detailsList.add(new DetailModel("Size", "200m2"));
        detailsList.add(new DetailModel("Bathrooms", "2"));
        detailsList.add(new DetailModel("Bedrooms", "2"));
        detailsList.add(new DetailModel("Rooms", "20"));
        detailsList.add(new DetailModel("Ownership", "Owner"));
        detailsList.add(new DetailModel("Floors", "3"));
        detailsList.add(new DetailModel("Energy efficent", "80 kWh EP / m2, year"));
        detailsList.add(new DetailModel("Gas emissions", "30 kg Co2 / m2, year"));

        AdapterDetail adapterDetail = new AdapterDetail(detailsList);
        recyclerViewDetails.setAdapter(adapterDetail);
    }

    private void setupIndoorOutdoorAmenities(){
        RecyclerView recyclerViewIndoorAmenities = findViewById(R.id.recyclerViewIndoorAmenities);
        RecyclerView recyclerViewOutdoorAmenities = findViewById(R.id.recyclerViewOutdoorAmenities);

        List<String> indoorAmenities = new ArrayList<>();
        indoorAmenities.add("Air conditioning");
        indoorAmenities.add("Cable TV");
        indoorAmenities.add("Computer");
        indoorAmenities.add("Microwave");

        recyclerViewIndoorAmenities.setAdapter(new AdapterAmenities(indoorAmenities));

        List<String> outdoorAmenities = new ArrayList<>();
        outdoorAmenities.add("Balcony");
        outdoorAmenities.add("Lift");
        outdoorAmenities.add("Pool");
        outdoorAmenities.add("Parking");

        recyclerViewOutdoorAmenities.setAdapter(new AdapterAmenities(outdoorAmenities));
    }


    public static class DetailModel{
        private String header, value;

        public DetailModel(String header, String value) {
            this.header = header;
            this.value = value;
        }

        public DetailModel() {
        }

        public String getHeader() {
            return header;
        }

        public void setHeader(String header) {
            this.header = header;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }
    }
}