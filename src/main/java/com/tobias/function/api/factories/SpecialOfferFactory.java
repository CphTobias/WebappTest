package com.tobias.function.api.factories;

import com.tobias.function.exceptions.ValidationError;

import java.util.ArrayList;

public class SpecialOfferFactory {

    private int id;
    private int carID;
    private String offer;
    private String sideMessage;

    public boolean isValid(SpecialOfferFactory specialOfferFactory) {
        return specialOfferFactory != null;
    }

    public void setId(int id) throws ValidationError {
        if(id < 0) throw new ValidationError("Specialofffers cannot have an id of less than 0");
        this.id = id;
    }

    public void setId(String number) throws ValidationError {
        try {
            setId(Integer.parseInt(number));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setCarID(int carID) throws ValidationError {
        if(carID < 0) throw new ValidationError("Cars with the id of less than 0 do not exist");
        this.carID = carID;
    }

    public void setCarID(String number) throws ValidationError {
        try {
            setCarID(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setCarID(String[] arrOfStr) throws ValidationError {
        ArrayList<String> cardetails = new ArrayList<>();
        for(String a:arrOfStr){
            cardetails.add(a);
        }
        String carID = cardetails.get(0);
        try {
            setCarID(Integer.parseInt(carID));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }



    public void setOffer(String offer) {
        this.offer = offer;
    }

    public void setSideMessage(String sideMessage) {
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
