package com.tobias.function.web.Admin;

import com.tobias.function.domain.User;
import com.tobias.function.exceptions.LoginSampleException;
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

        String userRole = request.getParameter("usersrole");
        List<User> userList = api.getUserFacade().findChosenUsers(userRole);
        request.setAttribute("showchosenrole", userList);
        return "admin/admininterface";
    }
}
