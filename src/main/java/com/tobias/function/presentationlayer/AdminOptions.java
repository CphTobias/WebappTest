package com.tobias.function.presentationlayer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminOptions extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String select = request.getParameter("adminselect");

        switch (select) {

            case "Add Car":
                request.setAttribute("addcar",select);
                break;
            case "Manage Car Availability":
                List<Car> cars = logicFacade.getAllCars();
                request.setAttribute("available",cars);
                break;
            case "Active Messages":
                List<ContactMessage> cMessageActive = logicFacade.getContactMessages(select);
                request.setAttribute("activeCM", cMessageActive);
                break;
            case "Closed Messages":
                List<ContactMessage> cMessageClosed = logicFacade.getContactMessages(select);
                request.setAttribute("activeCM", cMessageClosed);
                break;
            case "Show Users":
                request.setAttribute("showusers",select);
                break;
            case "Change Moderator Access":
                request.setAttribute("allusers",select);
                break;
            default: break;
        }

        return "admininterface";
    }
}
