package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.SpecialOfferFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateSpecialOffer extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        SpecialOfferFactory specialOfferFactory = new SpecialOfferFactory();

        try {
            String chosenCar = request.getParameter("offercar");
            String[] arrOfStr = chosenCar.split(",", 0);
            specialOfferFactory.setCarID(arrOfStr);
            specialOfferFactory.setOffer(request.getParameter("offer"));
            specialOfferFactory.setSideMessage(request.getParameter("sideMessage"));
        } catch (ValidationError e) {
            e.printStackTrace();
        }

        if(specialOfferFactory.isValid(specialOfferFactory)) {
            api.getSpecialOfferFacade().createSpecialOffer(specialOfferFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }

        return "admin/admininterface";
    }
}
