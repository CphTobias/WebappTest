package com.tobias.function.function.entities;

public class Car {

    /*
    id and available are automaticly set in the database.
     */
    private final int id;
    private final int horsepower;
    private final String brand;
    private double price;
    private final String category;
    private final String model;
    private final int weight;
    private final int buildyear;
    private final int milage;
    private final String imagename;
    private boolean available;


    public Car(int id, int horsepower, String brand, double price, String category, String model, int weight, int buildyear, int milage, String imagename, boolean available) {
        this.id = id;
        this.horsepower = horsepower;
        this.brand = brand;
        this.price = price;
        this.category = category;
        this.model = model;
        this.weight = weight;
        this.buildyear = buildyear;
        this.milage = milage;
        this.imagename = imagename;
        this.available = available;
    }

    public int getId() {
        return id;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getBrand() {
        return brand;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getCategory() {
        return category;
    }

    public String getModel() {
        return model;
    }

    public int getWeight() {
        return weight;
    }

    public int getBuildyear() {
        return buildyear;
    }

    public int getMilage() {
        return milage;
    }

    public String getImagename() {
        return imagename;
    }

    public boolean isAvailable() {
        return available;
    }

    public void setAvailable(boolean available) {
        this.available = available;
    }
}
