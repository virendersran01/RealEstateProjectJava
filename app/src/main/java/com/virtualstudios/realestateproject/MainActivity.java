package com.virtualstudios.realestateproject;

import androidx.annotation.DimenRes;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.card.MaterialCardView;
import com.google.android.material.textview.MaterialTextView;

import org.imaginativeworld.whynotimagecarousel.CarouselItem;
import org.imaginativeworld.whynotimagecarousel.ImageCarousel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MaterialTextView textAll;
    private MaterialTextView textSale;
    private MaterialTextView textRent;
    private MaterialTextView textSaleRent;
    private MaterialToolbar toolbar;
    private View viewSearch;
    private View viewFooter;
    private NestedScrollView nestedScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nestedScrollView = findViewById(R.id.scrollView);
        // AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        setupSearchLayout();
        setupImageCarouselView();
        setupPopularCities();
        setupPropertyListing();
        viewFooter = findViewById(R.id.viewFooter);
        viewFooter.setOnClickListener(v -> {
            if (viewSearch.getVisibility() == View.GONE) {
                toolbar.setVisibility(View.GONE);
                viewSearch.setVisibility(View.VISIBLE);
            }
            nestedScrollView.scrollTo((int)viewSearch.getX(), (int) viewSearch.getY());
        });

        nestedScrollView.setOnScrollChangeListener((NestedScrollView.OnScrollChangeListener) (v, scrollX, scrollY, oldScrollX, oldScrollY) -> {
            if (viewSearch.getVisibility() == View.VISIBLE){
                viewSearch.setVisibility(View.GONE);
                toolbar.setVisibility(View.VISIBLE);
            }

        });
    }


    private void setupImageCarouselView() {
        ImageCarousel carousel = findViewById(R.id.carouselView);
        List<CarouselItem> list = new ArrayList<>();
// Image URL with caption
        list.add(new CarouselItem("https://images.unsplash.com/photo-1532581291347-9c39cf10a73c?w=1080", "Photo by Aaron Wu on Unsplash"));
// Just image URL
        list.add(new CarouselItem("https://images.unsplash.com/photo-1534447677768-be436bb09401?w=1080"));
        list.add(new CarouselItem(R.drawable.city1));
        list.add(new CarouselItem(R.drawable.city2));
        list.add(new CarouselItem(R.drawable.city3));
        carousel.addData(list);
    }

    private void setupSearchLayout() {
        toolbar = findViewById(R.id.toolbar);
        MaterialCardView cardView = findViewById(R.id.cardToolbar);
        viewSearch = findViewById(R.id.layoutSearch);
        MaterialButton buttonClose = viewSearch.findViewById(R.id.buttonClose);
        Spinner spinnerCategories = viewSearch.findViewById(R.id.spinnerCategories);
        textAll = viewSearch.findViewById(R.id.textAll);
        textSale = viewSearch.findViewById(R.id.textSale);
        textRent = viewSearch.findViewById(R.id.textRent);
        textSaleRent = viewSearch.findViewById(R.id.textSaleRent);
        selectType(0);

        cardView.setOnClickListener(v -> {
            viewSearch.setVisibility(View.VISIBLE);
            toolbar.setVisibility(View.GONE);
        });

        buttonClose.setOnClickListener(v -> {
            viewSearch.setVisibility(View.GONE);
            toolbar.setVisibility(View.VISIBLE);
        });

        String[] categories = {"Apartment", "Commercial", "House", "Land", "Restaurant"};
        spinnerCategories.setAdapter(new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, categories));

        textAll.setOnClickListener(v -> selectType(0));
        textSale.setOnClickListener(v -> selectType(1));
        textRent.setOnClickListener(v -> selectType(2));
        textSaleRent.setOnClickListener(v -> selectType(3));


    }

    private void selectType(int type){ //type ==> 0 for all, 1 for sale, 2 for rent, 3 for saleRent
        switch (type){
            case 0:
                textAll.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.design_default_color_primary_dark)));
                textAll.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                textSale.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSale.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSaleRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSaleRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                break;
            case 1:
                textAll.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textAll.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSale.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.design_default_color_primary_dark)));
                textSale.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                textRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSaleRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSaleRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                break;
            case 2:
                textAll.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textAll.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSale.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSale.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.design_default_color_primary_dark)));
                textRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                textSaleRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSaleRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                break;
            case 3:
                textAll.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textAll.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSale.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textSale.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.white)));
                textRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.black));
                textSaleRent.setBackgroundTintList(ColorStateList.valueOf(ContextCompat.getColor(getApplicationContext(),R.color.design_default_color_primary_dark)));
                textSaleRent.setTextColor(ContextCompat.getColor(getApplicationContext(),R.color.white));
                break;
        }
    }

    private void setupPopularCities() {
        RecyclerView recyclerView = findViewById(R.id.rvPopularCities);
        recyclerView.setAdapter(new AdapterCity());
        recyclerView.addItemDecoration(new ItemOffsetDecoration(getApplicationContext(), R.dimen.city_items_offset));
    }

    private void setupPropertyListing() {
        RecyclerView recyclerView = findViewById(R.id.recyclerViewPropertyListing);
        recyclerView.setAdapter(new AdapterPropertyListing());
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