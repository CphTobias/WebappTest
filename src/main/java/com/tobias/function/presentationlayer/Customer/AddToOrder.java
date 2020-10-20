package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.function.entities.Order;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AddToOrder extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Takes a carID and the current sessions userid
        Creates an order, and then places the car into the order
         */
        LogicFacade logicFacade = new LogicFacade();
        String userID = request.getParameter("userid");
        String carID = request.getParameter("carid");
        String newCarID = carID + ",";
        Order order = logicFacade.findPreOrder(userID);
        String carIDs;

        if(order == null){
            logicFacade.createOrder(userID);
            logicFacade.updatePreOrder(newCarID, userID);
        } else {
            carIDs = order.getCarID();
            logicFacade.updatePreOrder(carIDs, newCarID, userID);
        }

        return "customer/RentACar";
    }
}
