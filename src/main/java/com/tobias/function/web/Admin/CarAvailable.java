package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.CarFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CarAvailable extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt fra Manage Car Availability
         */
        CarFactory carFactory = new CarFactory();
        try {
            carFactory.setId(request.getParameter("carid"));
            carFactory.setAvailable(request.getParameter("caravailable"));
            carFactory.setPrice(request.getParameter("changeprice"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(carFactory.isValid(carFactory)) {
            if (carFactory.getPrice() > 0) {
                api.getCarFacade().setCarToClosed(carFactory);
                api.getCarFacade().updatePrice(carFactory);
            } else {
                api.getCarFacade().setCarToClosed(carFactory);
            }
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }
        return "admin/admininterface";
    }
}
