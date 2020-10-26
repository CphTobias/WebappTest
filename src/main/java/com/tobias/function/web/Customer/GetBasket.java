package com.tobias.function.web.Customer;

import com.tobias.function.api.factories.OrderFactory;
import com.tobias.function.domain.Car;
import com.tobias.function.domain.Order;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetBasket extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        OrderFactory orderFactory = new OrderFactory();
        try {
            orderFactory.setUserID(request.getParameter("userid"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        /*
        Finds the preorder of of the user
        Split the cars up, and then find each one of them, then add them to an array of cars
         */
        if(orderFactory.isValid(orderFactory)) {
            Order getPreOrder = api.getOrderFacade().getPreOrder(orderFactory.getUserID());

            if (getPreOrder == null){
                return "customer/basket";
            }

            ArrayList<Car> preOrderCars = api.getCarFacade().getPreOrderCars(getPreOrder);
            double preOrderPrice = api.getOrderFacade().getPreOrderPrice(preOrderCars);

            request.setAttribute("orderprice", preOrderPrice);
            request.setAttribute("allpreorders", preOrderCars);
            request.setAttribute("preorder", getPreOrder);
            return "customer/basket";
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "Failed to update user");
            return "errors/errorpage";
        }
    }
}
