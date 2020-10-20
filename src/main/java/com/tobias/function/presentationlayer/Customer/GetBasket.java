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
        HttpSession session = request.getSession();
        String userID = request.getParameter("userid");

        /*
        Finds the preorder of of the user
        Split the cars up, and then find each one of them, then add them to an array of cars
         */
        Order preorder = logicFacade.findPreOrder(userID);

        String[] splitCars = preorder.getCarID().split(",");
        ArrayList<Car> carsInPreorder = new ArrayList<>();
        int newS;

        for (String s : splitCars) {
            newS = Integer.parseInt(s);
            Car car = logicFacade.findCar(newS);
            carsInPreorder.add(car);
        }

        double price = 0;
        for (Car c: carsInPreorder){
            double oldprice = price;
            price = oldprice + c.getPrice();
        }

        session.setAttribute("orderprice",price);
        session.setAttribute("allpreorders",carsInPreorder);
        session.setAttribute("preorder", preorder);
        return "customer/basket";
    }
}
