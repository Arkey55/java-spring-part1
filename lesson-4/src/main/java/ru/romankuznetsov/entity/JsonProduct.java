package ru.romankuznetsov.entity;

public class JsonProduct {
    private int id;
    private String name;
    private int price;

    public JsonProduct(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
