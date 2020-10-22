package com.tobias.function.presentationlayer;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.SpecialOffers;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {

        /*
        Called from Login.jsp
        The logicfacade checks if the user is banned, if that is true, it will return null.
        If the user is null it will return to the login page and tell the user that their account was banned.

        If the log
         */
        request.getServletContext().setAttribute("notloggedin", null);
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        user = userFacade.login(username, password);

        if (user == null){
            String userbanned = "Username or password was incorrect, or your user has been banned";
            request.setAttribute("userbanned", userbanned);
            return "Login";
        }

        HttpSession session = request.getSession();
        int getrank;
        String ranked;

        getrank = user.isRanked();
        ranked = Integer.toString(user.isRanked());

        if (getrank == 10){
            session.setAttribute("rank10", ranked);
        } else if (getrank == 50){
            session.setAttribute("rank50", ranked);
        } else if (getrank == 99){
            session.setAttribute("rank99", ranked);
        } else {
            session.setAttribute("norank", ranked);
        }

        if(user.getRole().equals("admin")){
            session.setAttribute("adminrole", user.getRole());
        } else {
            session.setAttribute("customerrole", user.getRole());
        }

        /*
        First we find out specialoffers.
        Create a List of Cars and find every car that has been set to a special offer.
         */
        List<SpecialOffers> specialOffers = specialOfferFacade.findSpecialOffers();
        if(specialOffers != null) {
            ArrayList<Car> soImages = new ArrayList<>();
            for (SpecialOffers s : specialOffers) {
                Car car = carFacade.findCar(s.getCarID());
                soImages.add(car);
            }
            session.setAttribute("specialoffer", specialOffers);
            session.setAttribute("specialcar", soImages);
        }

        session.setAttribute("bank", user.getBank());
        session.setAttribute("email",user.getEmail());
        session.setAttribute("user", user);
        session.setAttribute("username", username);// ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke
        // ;
        //request.setAttribute("user", user);

        return user.getRole() + "/" + user.getRole() + "page";
    }

}
