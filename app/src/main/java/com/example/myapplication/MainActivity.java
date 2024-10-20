package com.example.myapplication;

import android.os.Bundle;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.RecyclerView;

import android.content.res.Configuration;

import java.util.ArrayList;
import java.util.List;

// MainActivity class that serves as the entry point of the app
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Enable edge-to-edge display for a full-screen experience
        EdgeToEdge.enable(this);
        // Set the layout for the main activity
        setContentView(R.layout.activity_main);


        List<Fruit> fruits = loadFruitsFromResources();


        // Find the RecyclerView in the layout
        RecyclerView recyclerView = findViewById(R.id.recycler_view);


        // Set the FruitAdapter to the RecyclerView
        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);

        // Set the layout manager for the RecyclerView
        // If the device is a large screen (like a tablet), use 4 columns, otherwise use 1 column
        int spanCount = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE ? 4 : 1;
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
    }


    // Helper method to load the list of fruits from the resources.
    // Automatic add Fruits From string.xml file.
    private List<Fruit> loadFruitsFromResources() {
        List<Fruit> fruits = new ArrayList<>();
        String[] fruitNames = getResources().getStringArray(R.array.fruit_names);
        for (String fruitName : fruitNames) {
            int resourceId = getResources().getIdentifier(fruitName.toLowerCase(), "drawable", getPackageName());
            if (resourceId != 0) {
                fruits.add(new Fruit(getString(getResources().getIdentifier(fruitName.toLowerCase(), "string", getPackageName())), resourceId));
            }
        }
        return fruits;
    }
}