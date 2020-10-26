package com.tobias.function.domain;

public class SpecialOffers {

    private final int id;
    private final int carID;
    private final String offer;
    private final String sideMessage;

    public SpecialOffers(int id, int carID, String offer, String sideMessage) {
        this.id = id;
        this.carID = carID;
        this.offer = offer;
        this.sideMessage = sideMessage;
    }

    public int getId() {
        return id;
    }

    public int getCarID() {
        return carID;
    }

    public String getOffer() {
        return offer;
    }

    public String getSideMessage() {
        return sideMessage;
    }
}
