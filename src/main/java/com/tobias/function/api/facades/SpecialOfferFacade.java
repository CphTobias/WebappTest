package com.tobias.function.api.facades;

import com.tobias.function.api.factories.SpecialOfferFactory;
import com.tobias.function.domain.SpecialOffers;
import com.tobias.function.infrastructure.Database.DBSpecialOffers;

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
        return dbSpecialOffers.findSpecialOffers();
    }

    /*
    Called from CloseOffer, it takes a string of offerID and parses it to an Integer.
    Then calls the SpecialOfferHandler to delete that offer.
     */
    public void deleteSpecialOffer(SpecialOfferFactory specialOfferFactory) {
        dbSpecialOffers.deleteSpecialOffer(specialOfferFactory.getCarID());
    }

    /*
    Called from CreateSpecialOffer, it takes 3 strings and converts the first string into a string[], then finds the first value and
    converts it to an Integer.
    Calls the SpecialOffersHandler to create a special offer
    tring chosenCar, String offer, String sideMessage
     */
    public void createSpecialOffer(SpecialOfferFactory specialOfferFactory) {
        dbSpecialOffers.createSpecialOffer(specialOfferFactory.getCarID(),
                specialOfferFactory.getOffer(),
                specialOfferFactory.getSideMessage());
    }
}
