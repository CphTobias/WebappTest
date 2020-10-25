package com.tobias.function.web.Customer;

import com.tobias.function.domain.Car;
import com.tobias.function.domain.Order;
import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class GetBasket extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String userID = request.getParameter("userid");

        /*
        Finds the preorder of of the user
        Split the cars up, and then find each one of them, then add them to an array of cars
         */

        Order getPreOrder = api.getOrderFacade().getPreOrder(userID);
        ArrayList<Car> preOrderCars = api.getCarFacade().getPreOrderCars(getPreOrder);
        double preOrderPrice = api.getOrderFacade().getPreOrderPrice(preOrderCars);

        request.setAttribute("orderprice",preOrderPrice);
        request.setAttribute("allpreorders",preOrderCars);
        request.setAttribute("preorder", getPreOrder);
        return "customer/basket";
    }
}