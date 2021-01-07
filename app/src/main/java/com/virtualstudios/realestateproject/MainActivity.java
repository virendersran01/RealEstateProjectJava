package com.virtualstudios.realestateproject;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;

import org.imaginativeworld.whynotimagecarousel.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
       // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setupImageCarouselView();
        setupPopularCities();
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

    private void setupPopularCities(){
        RecyclerView recyclerView = findViewById(R.id.rvPopularCities);
        recyclerView.setAdapter(new AdapterCity());
        recyclerView.addItemDecoration(new ItemOffsetDecoration(getApplicationContext(), R.dimen.city_items_offset));
    }

    public static class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
        private final int mItemOffset;

        ItemOffsetDecoration(int itemOffset) {
            mItemOffset = itemOffset;
        }

        public ItemOffsetDecoration(@NonNull Context context, @DimenRes int itemOffsetId) {
            this(context.getResources().getDimensionPixelSize(itemOffsetId));
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent,
                                   @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
        }
    }

}