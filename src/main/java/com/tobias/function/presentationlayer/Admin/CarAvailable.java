package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CarAvailable extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String carid = request.getParameter("carid");
        String caravailable = request.getParameter("caravailable");
        String newPrice = request.getParameter("changeprice");

        if(newPrice.chars().findAny().isPresent()){
            logicFacade.setCarToClosed(carid, caravailable);
            logicFacade.updatePrice(carid, newPrice);
        } else {
            logicFacade.setCarToClosed(carid, caravailable);
        }

        return "admin/admininterface";
    }
}
