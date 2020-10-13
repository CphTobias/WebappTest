package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Handlers.CarHandler;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCar extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        CarHandler carHandler = new CarHandler();

        String horsepower = request.getParameter("horsepower");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String model = request.getParameter("model");
        String category = request.getParameter("category");
        String weight = request.getParameter("weight");
        String buildYear = request.getParameter("buildyear");
        String milage = request.getParameter("milage");
        String image = request.getParameter("image");

        int newhorsepower = Integer.parseInt(horsepower);
        double newprice = Double.parseDouble(price);
        int newweight = Integer.parseInt(weight);
        int newbuildyear = Integer.parseInt(buildYear);
        int newmilage = Integer.parseInt(buildYear);

        carHandler.createCar(newhorsepower,brand,newprice,model,category,newweight,newbuildyear,newmilage,image);

        return "admininterface";
    }
}
