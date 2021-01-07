package com.virtualstudios.realestateproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import org.imaginativeworld.whynotimagecarousel.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupImageCarouselView();
    }

    private void setupImageCarouselView(){
        ImageCarousel carousel = findViewById(R.id.carouselView);

        List<CarouselItem> list = new ArrayList<>();

//// Image URL with caption
//        list.add(
//                new CarouselItem(
//                        "https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080",
//                        "Photo by Aaron Wu on Unsplash"
//                )
//        );
//
//// Just image URL
//        list.add(
//                new CarouselItem(
//                        "https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"
//                )
//        );


        list.add(new CarouselItem(R.drawable.city1));
        list.add(new CarouselItem(R.drawable.city2));
        list.add(new CarouselItem(R.drawable.city3));
        carousel.addData(list);
    }
}