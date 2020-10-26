package com.tobias.function.api.factories;

import com.tobias.function.exceptions.ValidationError;

public class OrderFactory {

    private int id;
    private int userID;
    private String carID;
    private boolean paid;
    private double calculateOrder;
    private String chosenCar;

    public boolean isValid(OrderFactory orderFactory) {
        return orderFactory != null;
    }

    public void setChosenCar(String chosenCar) {
        this.chosenCar = chosenCar;
    }

    public void setCalculateOrder(double calculateOrder){
        this.calculateOrder = calculateOrder;
    }

    public void setCalculateOrder(String orderprice, String userbank) throws ValidationError {
        try {
            double newPrice = Double.parseDouble(orderprice);
            double newBank = Double.parseDouble(userbank);
            double calculate = newBank - newPrice;
            setCalculateOrder(calculate);
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setId(int id) throws ValidationError{
        if(id < 0) throw new ValidationError("The order cannot have an id of less than 0");
        this.id = id;
    }

    public void setId(String number) throws ValidationError {
        try {
            setId(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setUserID(int userID) throws ValidationError {
        if(userID < 0) throw new ValidationError("There are no users with an id of less than 0");
        this.userID = userID;
    }

    public void setUserID(String number) throws ValidationError {
        try {
            setUserID(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setCarID(String carID) {
        this.carID = carID;
    }

    public void setPaid(boolean paid) {
        this.paid = paid;
    }

    public void setPaid(String paid) throws ValidationError{
        try {
            setPaid(paid.equals("1") || paid.equals("true"));
        } catch (IllegalArgumentException e){
            throw new ValidationError(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public int getUserID() {
        return userID;
    }

    public String getCarID() {
        return carID;
    }

    public boolean isPaid() {
        return paid;
    }

    public double getCalculateOrder() {
        return calculateOrder;
    }

    public String getChosenCar() {
        return chosenCar;
    }
}
