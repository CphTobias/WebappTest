package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseOffer extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Called by the admininterface Manage Special Offers
        Calls the LogicFacade with a String given to us by Manage Special Offers
         */

        String offerID = request.getParameter("carid");
        specialOfferFacade.deleteSpecialOffer(offerID);
        return "admin/admininterface";
    }
}
