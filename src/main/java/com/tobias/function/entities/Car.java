package com.tobias.function.entities;

public class Car {

    /*`id` int(11) NOT NULL AUTO_INCREMENT,
    `Horsepower` int(11) DEFAULT NULL,
    `Make` varchar(255) COLLATE utf8_bin DEFAULT NULL,
    `Model` varchar(255) COLLATE utf8_bin DEFAULT NULL,
    `Weight` int(11) DEFAULT NULL,
    `BuildYear` int(11) DEFAULT NULL,
    `Milage` int(11) DEFAULT NULL,
    `imagename` varchar(255) COLLATE utf8_bin DEFAULT NULL,*/
    private final int id;
    private final int horsepower;
    private final String make;
    private final String model;
    private final int weight;
    private final int buildyear;
    private final int milage;
    private final String imagename;

    public Car(int id, int horsepower, String make, String model, int weight, int buildyear, int milage, String imagename) {
        this.id = id;
        this.horsepower = horsepower;
        this.make = make;
        this.model = model;
        this.weight = weight;
        this.buildyear = buildyear;
        this.milage = milage;
        this.imagename = imagename;
    }


    @Override
    public String toString() {
        return  "Brand: " + make +
                ", Model: " + model  +
                ", Horsepower: " + horsepower +
                ", Weight: " + weight +
                ", Year build: " + buildyear +
                ", Milage: " + milage;
    }

    public int getId() {
        return id;
    }

    public int getHorsepower() {
        return horsepower;
    }

    public String getMake() {
        return make;
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
}
