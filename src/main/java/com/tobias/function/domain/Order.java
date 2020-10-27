package com.tobias.function.domain;

import java.time.LocalDateTime;

public class Order {

    private final int id;
    private final int userID;
    private final String carID;
    private final boolean paid;
    private final double price;
    private final LocalDateTime paidAt;

    public Order(int id, int userID, String carID, boolean paid, double price, LocalDateTime paidAt) {
        this.id = id;
        this.userID = userID;
        this.carID = carID;
        this.paid = paid;
        this.price = price;
        this.paidAt = paidAt;
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

    public double getPrice() {
        return price;
    }

    public LocalDateTime getPaidAt() {
        return paidAt;
    }
}
