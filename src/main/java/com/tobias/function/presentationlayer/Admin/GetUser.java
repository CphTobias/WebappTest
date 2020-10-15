package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.entities.User;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetUser extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String userRole = request.getParameter("usersrole");
        List<User> userList = logicFacade.findChosenUsers(userRole);
        request.setAttribute("showchosenrole", userList);
        return "admin/admininterface";
    }
}
