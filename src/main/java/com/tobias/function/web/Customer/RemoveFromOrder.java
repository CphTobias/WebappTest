package com.tobias.function.web.Customer;

import com.tobias.function.api.factories.CarFactory;
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

public class RemoveFromOrder extends com.tobias.function.web.Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        OrderFactory orderFactory = new OrderFactory();

        orderFactory.setCarID(request.getParameter("preordercarid"));
        orderFactory.setChosenCar(request.getParameter("carid"));
        try {
            orderFactory.setUserID(request.getParameter("preorderuserid"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        String replace = orderFactory.getCarID().replaceFirst(orderFactory.getChosenCar(), "");
        String[] splitCars = replace.split(",");
        String cars = "";
        ArrayList<String> newCars = new ArrayList<>();

        for (String s : splitCars) {
            String oldCar = s + ",";
            if(!oldCar.startsWith(",")) {
                newCars.add(oldCar);
            }
        }
        for (String s:newCars) {
            cars = cars + s;
        }

        if(cars.startsWith(",")){
            cars = "";
        }

        if(orderFactory.isValid(orderFactory)) {
            api.getOrderFacade().updatePreOrder(cars, orderFactory.getUserID());
            Order getPreOrder = api.getOrderFacade().getPreOrder(orderFactory.getUserID());
            ArrayList<Car> preOrderCars;
            preOrderCars = api.getCarFacade().getPreOrderCars(getPreOrder);
            double preOrderPrice = api.getOrderFacade().getPreOrderPrice(preOrderCars);

            request.setAttribute("orderprice", preOrderPrice);
            request.setAttribute("allpreorders", preOrderCars);
            request.setAttribute("preorder", getPreOrder);
            return "customer/basket";
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }
    }
}
