package com.tobias.function.web.Customer;

import com.tobias.function.api.factories.OrderFactory;
import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.domain.Car;
import com.tobias.function.domain.Order;
import com.tobias.function.domain.User;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

public class PayOrder extends com.tobias.function.web.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        OrderFactory orderFactory = new OrderFactory();
        UserFactory userFactory = new UserFactory();
        HttpSession session = request.getSession();

        String orderprice = request.getParameter("orderprice");
        String userbank = request.getParameter("userbank");

        try {
            orderFactory.setCalculateOrder(orderprice, userbank);
            orderFactory.setUserID(request.getParameter("userid"));
            userFactory.setBank(orderFactory.getCalculateOrder());
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }


        Order getPreOrder = api.getOrderFacade().getPreOrder(orderFactory.getUserID());
        ArrayList<Car> preOrderCars = api.getCarFacade().getPreOrderCars(getPreOrder);
        double preOrderPrice = api.getOrderFacade().getPreOrderPrice(preOrderCars);

        if(orderFactory.isValid(orderFactory)) {
            if (orderFactory.getCalculateOrder() >= 0) {

                User user = api.getUserFacade().findUser(orderFactory.getUserID());
                userFactory.setName(user.getName());
                api.getUserFacade().updateUserBank(userFactory);
                Order order = api.getOrderFacade().orderPurchased(orderFactory);
                session.setAttribute("bank", userFactory.getBank());
                request.setAttribute("order", order);
                request.setAttribute("user", user);
                request.setAttribute("orderprice", orderprice);
                request.setAttribute("allpreorders", preOrderCars);
            } else {
                String nomoney = "You do not have enough money to purchase this order";
                request.setAttribute("orderprice", preOrderPrice);
                request.setAttribute("allpreorders", preOrderCars);
                request.setAttribute("preorder", getPreOrder);
                request.setAttribute("paymentfailed", nomoney);
                return "customer/basket";
            }
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }
        return "customer/receipt";
    }
}
