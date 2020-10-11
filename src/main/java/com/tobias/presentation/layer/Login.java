package com.tobias.presentation.layer;

import com.tobias.function.entities.User.User;
import com.tobias.function.layer.InvalidPassword;
import com.tobias.function.layer.LogicFacade;
import com.tobias.function.layer.LoginSampleException;
import com.tobias.function.layer.WebAppRepository;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 The purpose of Login is to...

 @author kasper
 */
public class Login extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response ) throws LoginSampleException {
        LogicFacade logicFacade = new LogicFacade();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = null;
        try {
            user = logicFacade.login(username, password);
        } catch (InvalidPassword invalidPassword) {
            invalidPassword.printStackTrace();
        }

        HttpSession session = request.getSession();

        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        session.setAttribute("username", username);  // ellers skal man skrive  user.email på jsp siderne og det er sgu lidt mærkeligt at man har adgang til private felter. Men måske er det meget fedt , jeg ved det ikke


        return user.getRole() + "page";
    }

}
