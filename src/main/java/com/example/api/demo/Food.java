package com.example.api.demo;

public class Food {
    private String id;
    private String Name;
    private int price;
    public Food() {
    }
    public Food(String id, String name, int price) {
        this.id = id;
        this.Name = name;
        this.price = price;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }
    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
