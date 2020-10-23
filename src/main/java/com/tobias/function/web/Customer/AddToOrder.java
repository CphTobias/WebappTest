package com.tobias.function.web.Customer;

import com.tobias.function.domain.order.Order;
import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddToOrder extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Takes a carID and the current sessions userid
        Creates an order, and then places the car into the order
         */
        String userID = request.getParameter("userid");
        String carID = request.getParameter("carid");
        String newCarID = carID + ",";
        Order order = orderFacade.findPreOrder(userID);
        String carIDs;

        if(order == null){
            orderFacade.createOrder(userID);
            orderFacade.updatePreOrder(newCarID, userID);
        } else {
            carIDs = order.getCarID();
            orderFacade.updatePreOrder(carIDs, newCarID, userID);
        }

        return "customer/RentACar";
    }
}
