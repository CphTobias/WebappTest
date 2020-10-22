package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserRole extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt fra Update User Role
         */

        String userName = request.getParameter("username");
        String userRole = request.getParameter("userrole");
        String userRank = request.getParameter("userrank");

        userFacade.updateRole(userName,userRole,userRank);

        return "admin/admininterface";
    }
}
