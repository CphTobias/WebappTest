package com.tobias.function.presentationlayer;

import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserRole extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();
        String userName = request.getParameter("username");
        String userRole = request.getParameter("userrole");

        logicFacade.updateUser(userName,userRole);

        return "admininterface";
    }
}
