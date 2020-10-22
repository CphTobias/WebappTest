package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CreateSpecialOffer extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String chosenCar = request.getParameter("offercar");
        String offer = request.getParameter("offer");
        String sideMessage = request.getParameter("sideMessage");
        logicFacade.createSpecialOffer(chosenCar,offer,sideMessage);
        return "admin/admininterface";
    }
}
