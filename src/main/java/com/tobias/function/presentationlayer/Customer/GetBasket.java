package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.Order;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class GetBasket extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String userID = request.getParameter("userid");

        /*
        Finds the preorder of of the user
        Split the cars up, and then find each one of them, then add them to an array of cars
         */

        Order getPreOrder = logicFacade.getPreOrder(userID);
        ArrayList<Car> preOrderCars = logicFacade.getPreOrderCars(getPreOrder);
        double preOrderPrice = logicFacade.getPreOrderPrice(preOrderCars);

        request.setAttribute("orderprice",preOrderPrice);
        request.setAttribute("allpreorders",preOrderCars);
        request.setAttribute("preorder", getPreOrder);
        return "customer/basket";
    }
}