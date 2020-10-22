package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.Order;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class PayOrder extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String orderprice = request.getParameter("orderprice");
        String userID = request.getParameter("userid");
        String userbank = request.getParameter("userbank");
        double newOrderPrice = Double.parseDouble(orderprice);
        double newUserBank = Double.parseDouble(userbank);
        double calculateOrder = newUserBank - newOrderPrice;

        Order getPreOrder = orderFacade.getPreOrder(userID);
        ArrayList<Car> preOrderCars = carFacade.getPreOrderCars(getPreOrder);
        double preOrderPrice = orderFacade.getPreOrderPrice(preOrderCars);

        if (calculateOrder >= 0){
            User user = userFacade.findUser(userID);
            userFacade.updateUserBank(user.getName(),calculateOrder);
            Order order = orderFacade.orderPurchased(userID);
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
