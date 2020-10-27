package com.tobias.function.web.Customer;

import com.tobias.function.domain.Order;
import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetUserOrders extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        HttpSession session = request.getSession();
        String userID = request.getParameter("userid");
        int newUserID;
        try {
            newUserID = Integer.parseInt(userID);
        } catch (NumberFormatException e){
            throw new NumberFormatException(e.getMessage());
        }

        List<Order> orderList = api.getOrderFacade().getUserOrders(newUserID);

        if(orderList != null){
            session.setAttribute("orders", orderList);
        } else {
            request.setAttribute("noorders", "You dont have any orders");
        }


        return "customer/AllUserOrders";
    }
}
