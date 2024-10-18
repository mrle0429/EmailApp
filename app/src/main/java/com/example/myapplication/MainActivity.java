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


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        
        List<Fruit> fruits = loadFruitsFromResources();



         //设置RecyclerView
        RecyclerView recyclerView = findViewById(R.id.recycler_view);

        if (recyclerView == null) {
            throw new IllegalStateException("RecyclerView not found. Please check if the ID is correctly set in the layout file.");
        }
        FruitAdapter adapter = new FruitAdapter(fruits);
        recyclerView.setAdapter(adapter);

        // 根据设备大小设置不同的列数
        int spanCount = (getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) 
            >= Configuration.SCREENLAYOUT_SIZE_LARGE ? 4 : 1;
        recyclerView.setLayoutManager(new GridLayoutManager(this, spanCount));
    }


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