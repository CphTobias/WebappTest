package com.tobias.function.presentationlayer;

import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Redirect extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        String destination = request.getParameter("destination");

        switch (destination){

            case "index": request.setAttribute("message", "Alt er godt!!!"); break;
            case "Login": break;
            case "customerpage":
                destination = "customer/customerpage";
                break;
            case "FAQ": break;
            case "adminpage":
                destination = "admin/adminpage";
                break;
            case "admininterface":
                destination = "admin/admininterface";
                break;
            case "Signup": break;
            case "RentACar":
                destination = "customer/RentACar";
                break;
            
            default:
                request.setAttribute("message", "Denne side findes ikke");
                break;

        }

        return destination;
    }
}

