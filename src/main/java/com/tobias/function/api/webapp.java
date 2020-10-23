package com.tobias.function.api;

import com.tobias.function.api.facades.CarFacade;
import com.tobias.function.api.facades.MessageFacade;
import com.tobias.function.api.facades.OrderFacade;
import com.tobias.function.api.facades.UserFacade;
import com.tobias.function.domain.SpecialOfferFacade;

public class webapp {
    private final CarFacade carFacade;
    private final MessageFacade messageFacade;
    private final OrderFacade orderFacade;
    private final SpecialOfferFacade specialOfferFacade;
    private final UserFacade userFacade;

    public webapp(CarFacade carFacade, MessageFacade messageFacade, OrderFacade orderFacade, SpecialOfferFacade specialOfferFacade, UserFacade userFacade) {
        this.carFacade = carFacade;
        this.messageFacade = messageFacade;
        this.orderFacade = orderFacade;
        this.specialOfferFacade = specialOfferFacade;
        this.userFacade = userFacade;
    }

    public CarFacade getCarFacade() {
        return carFacade;
    }

    public MessageFacade getMessageFacade() {
        return messageFacade;
    }

    public OrderFacade getOrderFacade() {
        return orderFacade;
    }

    public SpecialOfferFacade getSpecialOfferFacade() {
        return specialOfferFacade;
    }

    public UserFacade getUserFacade() {
        return userFacade;
    }
}
