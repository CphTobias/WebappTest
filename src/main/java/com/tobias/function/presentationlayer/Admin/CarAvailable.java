package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

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

        String carid = request.getParameter("carid");
        String caravailable = request.getParameter("caravailable");
        String newPrice = request.getParameter("changeprice");

        if(newPrice.chars().findAny().isPresent()){
            carFacade.setCarToClosed(carid, caravailable);
            carFacade.updatePrice(carid, newPrice);
        } else {
            carFacade.setCarToClosed(carid, caravailable);
        }

        return "admin/admininterface";
    }
}
