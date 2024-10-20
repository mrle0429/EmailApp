package com.example.myapplication;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

// Adapter class for managing the display of fruit items in a RecyclerView
public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    // List of Fruit objects to display in the RecyclerView
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    // This method inflates the layout for individual items in the RecyclerView
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Inflate the item_fruit layout for each fruit item
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_fruit, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Fruit fruit = fruits.get(position);
        holder.bind(fruit);
    }

    @Override
    public int getItemCount() {
        return fruits.size();
    }

    // ViewHolder class for holding references to the views within each fruit item
    class ViewHolder extends RecyclerView.ViewHolder {
        // ImageView to display the fruit image
        private ImageView fruitImage;


        public ViewHolder(View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.fruit_image);

            // Create an intent to start the FruitDetailActivity and pass the fruit's name and image ID
            itemView.setOnClickListener(v -> {
                int position = getAdapterPosition();
                Fruit clickedFruit = fruits.get(position);
                Intent intent = new Intent(itemView.getContext(), FruitDetailActivity.class);
                intent.putExtra("FRUIT_NAME", clickedFruit.getName());
                intent.putExtra("FRUIT_IMAGE_ID", clickedFruit.getImageResourceId());
                itemView.getContext().startActivity(intent);
            });
        }

        public void bind(Fruit fruit) {
            fruitImage.setImageResource(fruit.getImageResourceId());
        }
    }
}

