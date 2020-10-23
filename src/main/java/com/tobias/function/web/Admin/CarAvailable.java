package com.tobias.function.web.Admin;

import com.tobias.function.exceptions.LoginSampleException;
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

        String carid = request.getParameter("carid");
        String caravailable = request.getParameter("caravailable");
        String newPrice = request.getParameter("changeprice");

        if(newPrice.chars().findAny().isPresent()){
            api.getCarFacade().setCarToClosed(carid, caravailable);
            api.getCarFacade().updatePrice(carid, newPrice);
        } else {
            api.getCarFacade().setCarToClosed(carid, caravailable);
        }

        return "admin/admininterface";
    }
}
