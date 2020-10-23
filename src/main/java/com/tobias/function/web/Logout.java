package com.tobias.function.web;

import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class Logout extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {

        /*
        Called when user clicks the Logout button
        It is done so that the session instances that might have been set during a login are not there anymore.
         */
        String userid = request.getParameter("userid");
        String answer = request.getParameter("logoutans");

        if(answer.equals("No")){
            orderFacade.deletePreOrder(userid);
        }

        HttpSession session = request.getSession();
        session.invalidate();

        return "index";
    }
}
