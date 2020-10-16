package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Handlers.UserHandler;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        LogicFacade logicFacade = new LogicFacade();
        String username = request.getParameter("username");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = null;
            try {
                user = logicFacade.createUser(username, password1);
            } catch (UserExists userExists) {
                throw new LoginSampleException("User already exists");
            }
            HttpSession session = request.getSession();

            session.setAttribute("username",username);
            session.setAttribute( "user", user);
            session.setAttribute( "role", user.getRole());
            return user.getRole() + "/" + user.getRole() + "page";
        } else {
            throw new LoginSampleException( "the two passwords did not match" );
        }
    }

}