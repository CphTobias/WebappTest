package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Handlers.CarHandler;
import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetCarOptions extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        CarMapper carMapper = new CarMapper();
        CarHandler carHandler = new CarHandler();
        String carselect = request.getParameter("caroptions");

        switch (carselect) {

            case "Add Car":
                request.setAttribute("addcar",carselect);
                break;
            case "Manage Car Availability":
                List<Car> cCars = carMapper.getAllCars();
                request.setAttribute("available",cCars);
                break;
            case "Manage Unavailable Cars":
                //
                break;
            case "Update Car Price":
                //request.setAttribute();
                break;
            default: break;
        }

        return "admininterface";
    }
}
