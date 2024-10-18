package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.TypedValue;
import android.content.res.Configuration;

import androidx.appcompat.app.AppCompatActivity;

public class FruitDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fruit_detail);

        String fruitName = getIntent().getStringExtra("FRUIT_NAME");
        int fruitImageId = getIntent().getIntExtra("FRUIT_IMAGE_ID", -1);

        TextView fruitNameTextView = findViewById(R.id.fruit_name_detail);
        ImageView fruitImageView = findViewById(R.id.fruit_image_detail);
        TextView fruitInitialTextView = findViewById(R.id.fruit_initial);

        fruitNameTextView.setText(fruitName);
        fruitImageView.setImageResource(fruitImageId);
        fruitInitialTextView.setText(fruitName.substring(0, 1));  

        
        if ((getResources().getConfiguration().screenLayout & Configuration.SCREENLAYOUT_SIZE_MASK) 
                >= Configuration.SCREENLAYOUT_SIZE_LARGE) {
            fruitNameTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 72);
            fruitInitialTextView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 180);
        }
    }


}