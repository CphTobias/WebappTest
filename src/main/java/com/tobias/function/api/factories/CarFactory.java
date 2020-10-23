package com.tobias.function.api.factories;

import com.tobias.function.exceptions.ValidationError;

import javax.validation.ValidationException;

public class CarFactory {
    private int horsepower;
    private String brand;
    private double price;
    private String category;
    private String model;
    private int weight;
    private int buildyear;
    private int milage;
    private String imagename;
    private boolean available;

    public boolean isValid (CarFactory carFactory){
        if (carFactory == null){
            return false;
        }
        return true;
    }

    public void setHorsepower(int horsepower) throws ValidationError {
        if(horsepower < 0) throw new ValidationError("Horsepower can't be under 0");
        this.horsepower = horsepower;
    }

    public void setHorsepower(String number) throws ValidationError {
        try {
            setHorsepower(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setPrice(double price) throws ValidationError {
        if(price < 0) throw new ValidationError("The price cannot be less than 0");
        this.price = price;
    }

    public void setPrice(String number) throws ValidationError {
        try {
            setPrice(Double.parseDouble(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setWeight(int weight) throws ValidationError {
        if(weight < 0) throw new ValidationError("Cars cannot weigh less than 0");
        this.weight = weight;
    }

    public void setWeight(String number) throws ValidationError {
        try {
            setWeight(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setBuildyear(int buildyear) throws ValidationError {
        if(buildyear < 0) throw new ValidationError("Cars cannot be build before year 0 i believe");
        this.buildyear = buildyear;
    }

    public void setBuildyear(String number) throws ValidationError {
        try {
            setBuildyear(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setMilage(int milage) throws ValidationError {
        if(milage < 0) throw new ValidationError("Milage cannot be less than 0");
        this.milage = milage;
    }

    public void setMilage(String number) throws ValidationError {
        try {
            setMilage(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setImagename(String imagename) {
        this.imagename = imagename;
    }

    public void setAvailable(boolean available) {
        this.available = available;
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
}
