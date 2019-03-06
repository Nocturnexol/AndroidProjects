package com.example.recyclerview;

public class Fruit {
    public String getName() {
        return name;
    }

    public Fruit(String name, int imageId) {
        this.name = name;
        this.imageId = imageId;
    }

    public int getImageId() {
        return imageId;
    }

    private String name;
    private int imageId;

}
