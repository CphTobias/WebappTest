package com.tobias.function.web.Customer;

import com.tobias.function.domain.Car;
import com.tobias.function.domain.Order;
import com.tobias.function.domain.User;
import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PayOrder extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String orderprice = request.getParameter("orderprice");
        String userID = request.getParameter("userid");
        String userbank = request.getParameter("userbank");
        double newOrderPrice = Double.parseDouble(orderprice);
        double newUserBank = Double.parseDouble(userbank);
        double calculateOrder = newUserBank - newOrderPrice;

        Order getPreOrder = api.getOrderFacade().getPreOrder(userID);
        ArrayList<Car> preOrderCars = api.getCarFacade().getPreOrderCars(getPreOrder);
        double preOrderPrice = api.getOrderFacade().getPreOrderPrice(preOrderCars);

        if (calculateOrder >= 0){
            User user = api.getUserFacade().findUser(userID);
            api.getUserFacade().updateUserBank(user.getName(),calculateOrder);
            Order order = api.getOrderFacade().orderPurchased(userID);
            request.setAttribute("order", order);
        } else {
            String nomoney = "You do not have enough money to purchase this order";
            request.setAttribute("orderprice",preOrderPrice);
            request.setAttribute("allpreorders",preOrderCars);
            request.setAttribute("preorder", getPreOrder);
            request.setAttribute("paymentfailed",nomoney);
            return "customer/basket";
        }

        return "customer/payment";
    }
}
