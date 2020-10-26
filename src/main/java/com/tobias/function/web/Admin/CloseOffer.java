package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.SpecialOfferFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseOffer extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Called by the admininterface Manage Special Offers
        Calls the LogicFacade with a String given to us by Manage Special Offers
         */
        SpecialOfferFactory specialOfferFactory = new SpecialOfferFactory();
        try {
            specialOfferFactory.setCarID(request.getParameter("carid"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(specialOfferFactory.isValid(specialOfferFactory)){
            api.getSpecialOfferFacade().deleteSpecialOffer(specialOfferFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }

        return "admin/admininterface";
    }
}
