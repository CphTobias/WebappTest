package com.tobias.function.web.Admin;

import com.tobias.function.domain.Car;
import com.tobias.function.domain.ContactMessage;
import com.tobias.function.domain.SpecialOffers;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class AdminOptions extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Tager imod strings fra de første dropdowns fra alle admin selectsne
         */


        String select = request.getParameter("adminselect");

        switch (select) {

            case "Add Car":
                request.setAttribute("addcar",select);
                break;
            case "Manage Car Availability":
                List<Car> cars = api.getCarFacade().getAllCars();
                request.setAttribute("available",cars);
                break;
            case "Manage Special Offers":
                List<SpecialOffers> specialOffers = api.getSpecialOfferFacade().findSpecialOffers();
                List<Car> allCars = api.getCarFacade().getAllCars();
                request.setAttribute("allcars",allCars);
                request.setAttribute("showactiveoffers", specialOffers);
                request.setAttribute("addspecialoffer", select);
                break;
            case "Active Messages":
                List<ContactMessage> cMessageActive = api.getMessageFacade().getContactMessages(select);
                request.setAttribute("activeCM", cMessageActive);
                break;
            case "Closed Messages":
                List<ContactMessage> cMessageClosed = api.getMessageFacade().getContactMessages(select);
                request.setAttribute("activeCM", cMessageClosed);
                break;
            case "Show Users":
                request.setAttribute("showusers",select);
                break;
            case "Change Moderator Access":
                request.setAttribute("allusers",select);
                break;
            case "Manage User Money":
                request.setAttribute("managemoney", select);
                break;
            default: break;
        }

        return "admin/admininterface";
    }
}
