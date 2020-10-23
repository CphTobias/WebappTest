package com.tobias.function.domain;

public class Order {

    /*
    NOT IN USE YET
     */
    private final int id;
    private final int userID;
    private final String carID;
    private final boolean paid;

    public Order(int id, int userID, String carID, boolean paid) {
        this.id = id;
        this.userID = userID;
        this.carID = carID;
        this.paid = paid;
    }

    public int getId() {
        return id;
    }

    public String getCarID() {
        return carID;
    }

    public int getUserID() {
        return userID;
    }

    public boolean isPaid() {
        return paid;
    }
}
