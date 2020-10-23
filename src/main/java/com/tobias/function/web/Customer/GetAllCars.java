package com.tobias.function.web.Customer;

import com.tobias.function.domain.Car;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class GetAllCars extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        List<Car> cars = api.getCarFacade().findAvailableCars();
        HttpSession session = request.getSession();

        session.setAttribute("allavailablecars", cars);

        return "customer/RentACar";
    }
}
