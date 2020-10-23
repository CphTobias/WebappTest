package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.CarFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AddNewCar extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Kalder logicfacade createCar for at tilføje en ny bil til databasen
        Bliver kaldt fra Add Car
         */
        CarFactory carFactory = new CarFactory();


        try {
            carFactory.setHorsepower(request.getParameter("horsepower"));
            carFactory.setBrand(request.getParameter("brand"));
            carFactory.setPrice(request.getParameter("price"));
            carFactory.setModel(request.getParameter("model"));
            carFactory.setCategory(request.getParameter("category"));
            carFactory.setWeight(request.getParameter("weight"));
            carFactory.setBuildyear(request.getParameter("buildyear"));
            carFactory.setMilage(request.getParameter("milage"));
            carFactory.setImagename(request.getParameter("image"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(carFactory.isValid(carFactory)){
            api.getCarFacade().createCar(carFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }
        return "admin/admininterface";
    }
}
