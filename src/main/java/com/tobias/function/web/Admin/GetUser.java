package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.domain.User;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUser extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt fra Show Users From
        Retunere til Show Users Chosen
         */
        UserFactory userFactory = new UserFactory();
        userFactory.setRole(request.getParameter("usersrole"));

        if(userFactory.isValid(userFactory)) {
            List<User> userList = api.getUserFacade().findChosenUsers(userFactory.getRole());
            request.setAttribute("showchosenrole", userList);
            return "admin/admininterface";
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal agrument was made");
            return "errors/errorpage";
        }
    }
}
