package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Database.DBSpecialOffers;
import com.tobias.function.function.entities.SpecialOffers;

import java.util.ArrayList;
import java.util.List;

public class SpecialOfferFacade {

    private static SpecialOfferFacade instance;

    private final DBSpecialOffers dbSpecialOffers;

    public SpecialOfferFacade(DBSpecialOffers dbSpecialOffers) {
        this.dbSpecialOffers = dbSpecialOffers;
    }

    public static SpecialOfferFacade getInstance() {
        if (instance == null) {
            instance = new SpecialOfferFacade(new DBSpecialOffers());
        }
        return instance;
    }

    /*
    Called when logging in to find the SpecialOffers for the customer page
    It calls the SpecialOffersMapper and returns a list of specialoffers
     */
    public List<SpecialOffers> findSpecialOffers() {
        List<SpecialOffers> specialOffers = dbSpecialOffers.findSpecialOffers();
        return specialOffers;
    }

    /*
    Called from CloseOffer, it takes a string of offerID and parses it to an Integer.
    Then calls the SpecialOfferHandler to delete that offer.
     */
    public void deleteSpecialOffer(String offerID) {
        int newOfferID = Integer.parseInt(offerID);
        dbSpecialOffers.deleteSpecialOffer(newOfferID);
    }

    /*
    Called from CreateSpecialOffer, it takes 3 strings and converts the first string into a string[], then finds the first value and
    converts it to an Integer.
    Calls the SpecialOffersHandler to create a special offer
     */
    public void createSpecialOffer(String chosenCar, String offer, String sideMessage) {
        String[] arrOfStr = chosenCar.split(",", 0);
        ArrayList<String> cardetails = new ArrayList<>();
        for(String a:arrOfStr){
            cardetails.add(a);
        }
        String carID = cardetails.get(0);
        int newCarID = Integer.parseInt(carID);
        dbSpecialOffers.createSpecialOffer(newCarID,offer,sideMessage);
    }
}
