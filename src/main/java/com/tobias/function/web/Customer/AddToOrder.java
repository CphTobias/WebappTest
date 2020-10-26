package com.tobias.function.web.Customer;

import com.tobias.function.api.factories.OrderFactory;
import com.tobias.function.domain.Order;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

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
        OrderFactory orderFactory = new OrderFactory();
        try {
            orderFactory.setUserID(request.getParameter("userid"));
            String carID = request.getParameter("carid");
            String newCarID = carID + ",";
            orderFactory.setCarID(newCarID);
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(orderFactory.isValid(orderFactory)) {
            Order order = api.getOrderFacade().findPreOrder(orderFactory.getUserID());
            String carIDs;

            if (order == null) {
                api.getOrderFacade().createOrder(orderFactory.getUserID());
                api.getOrderFacade().updatePreOrder(orderFactory.getCarID(), orderFactory.getUserID());
            } else {
                carIDs = order.getCarID();
                api.getOrderFacade().updatePreOrder(carIDs, orderFactory.getCarID(), orderFactory.getUserID());
            }
            return "customer/RentACar";
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "Failed to update user");
            return "errors/errorpage";
        }
    }
}
