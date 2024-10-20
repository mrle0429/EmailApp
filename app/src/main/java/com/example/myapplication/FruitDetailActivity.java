package com.example.myapplication;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.TypedValue;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatActivity;

// Activity to display the detailed information of a selected fruit
public class FruitDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Set the layout for the detail activity
        setContentView(R.layout.activity_fruit_detail);

        String fruitName = getIntent().getStringExtra("FRUIT_NAME");
        int fruitImageId = getIntent().getIntExtra("FRUIT_IMAGE_ID", -1);

        // Find the TextView and ImageView elements in the layout
        TextView fruitNameTextView = findViewById(R.id.fruit_name_detail);
        ImageView fruitImageView = findViewById(R.id.fruit_image_detail);
        TextView fruitInitialTextView = findViewById(R.id.fruit_initial);

        // Set the fruit name and image and initial in the corresponding views
        fruitNameTextView.setText(fruitName);
        fruitImageView.setImageResource(fruitImageId);
        fruitInitialTextView.setText(fruitName.substring(0, 1));

    }


}