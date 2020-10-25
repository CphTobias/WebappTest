package com.tobias.function.web;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.domain.User;
import com.tobias.function.exceptions.UserExists;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Register extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        UserFactory userFactory = new UserFactory();
        userFactory.setName(request.getParameter("username"));
        userFactory.setEmail(request.getParameter("email"));
        userFactory.setPassword(request.getParameter("password1"));
        userFactory.setPassword2(request.getParameter("password2"));

        if(userFactory.isValid(userFactory)) {
            if (userFactory.getPassword().equals(userFactory.getPassword2())) {
                User user = null;
                user = api.getUserFacade().createUser(userFactory);

                HttpSession session = request.getSession();

                session.setAttribute("email", user.getEmail());
                session.setAttribute("username", user.getName());
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole());
                return user.getRole() + "/" + user.getRole() + "page";
            } else {
                request.setAttribute("nomatch", "The two passwords did not match");
                return "Signup";
            }
        }
        request.setAttribute("error400", "400");
        request.setAttribute("error", "An illigal input was made");
        return "errors/errorpage";
    }

}