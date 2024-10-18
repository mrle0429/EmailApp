package com.example.myapplication;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<Fruit> fruits;

    public FruitAdapter(List<Fruit> fruits) {
        this.fruits = fruits;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
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

    class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView fruitImage;

        public ViewHolder(View itemView) {
            super(itemView);
            fruitImage = itemView.findViewById(R.id.fruit_image);

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

