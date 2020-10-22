package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCar extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Kalder logicfacade createCar for at tilføje en ny bil til databasen
        Bliver kaldt fra Add Car
         */

        String horsepower = request.getParameter("horsepower");
        String brand = request.getParameter("brand");
        String price = request.getParameter("price");
        String model = request.getParameter("model");
        String category = request.getParameter("category");
        String weight = request.getParameter("weight");
        String buildYear = request.getParameter("buildyear");
        String milage = request.getParameter("milage");
        String image = request.getParameter("image");


        carFacade.createCar(horsepower,brand,price,category,model,weight,buildYear,milage,image);

        return "admin/admininterface";
    }
}
