package com.example.myapplication;

public class Fruit {
    private String name;
    private int imageResourceId;

    public Fruit(String name, int imageResourceId) {
        this.name = name;
        this.imageResourceId = imageResourceId;
    }

    public String getName() {
        return name;
    }

    public int getImageResourceId() {
        return imageResourceId;
    }

}
