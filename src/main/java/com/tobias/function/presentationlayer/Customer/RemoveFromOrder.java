package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.Order;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class RemoveFromOrder extends com.tobias.function.presentationlayer.Command {

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

        logicFacade.updatePreOrder(cars,preOrderUserID);
        Order getPreOrder = logicFacade.getPreOrder(preOrderUserID);
        ArrayList<Car> preOrderCars = logicFacade.getPreOrderCars(getPreOrder);
        double preOrderPrice = logicFacade.getPreOrderPrice(preOrderCars);

        request.setAttribute("orderprice",preOrderPrice);
        request.setAttribute("allpreorders",preOrderCars);
        request.setAttribute("preorder", getPreOrder);

        return "customer/basket";
    }
}
