package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAllCars extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        List<Car> cars = logicFacade.findAvailableCars();
        HttpSession session = request.getSession();

        session.setAttribute("allavailablecars", cars);

        return "customer/RentACar";
    }
}
