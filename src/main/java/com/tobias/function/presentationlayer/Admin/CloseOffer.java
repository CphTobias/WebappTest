package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CloseOffer extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String offerID = request.getParameter("closeoffer");
        logicFacade.deleteSpecialOffer(offerID);
        return "admin/admininterface";
    }
}