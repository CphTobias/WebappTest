package com.tobias.function.web.Customer;

import com.tobias.function.domain.car.Car;
import com.tobias.function.domain.order.Order;
import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveFromOrder extends com.tobias.function.web.Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        String preOrderCarID = request.getParameter("preordercarid");
        String carID = request.getParameter("carid");
        String preOrderUserID = request.getParameter("preorderuserid");

        String replace = preOrderCarID.replaceFirst(carID, "");
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

        orderFacade.updatePreOrder(cars,preOrderUserID);
        Order getPreOrder = orderFacade.getPreOrder(preOrderUserID);
        ArrayList<Car> preOrderCars = carFacade.getPreOrderCars(getPreOrder);
        double preOrderPrice = orderFacade.getPreOrderPrice(preOrderCars);

        request.setAttribute("orderprice",preOrderPrice);
        request.setAttribute("allpreorders",preOrderCars);
        request.setAttribute("preorder", getPreOrder);

        return "customer/basket";
    }
}
