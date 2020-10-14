package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Handlers.CarHandler;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCar extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();

        String horsepower = request.getParameter("horsepower");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String model = request.getParameter("model");
        String category = request.getParameter("category");
        String weight = request.getParameter("weight");
        String buildYear = request.getParameter("buildyear");
        String milage = request.getParameter("milage");
        String image = request.getParameter("image");

        logicFacade.createCar(horsepower,brand,price,category,model,weight,buildYear,milage,image);

        return "admininterface";
    }
}
