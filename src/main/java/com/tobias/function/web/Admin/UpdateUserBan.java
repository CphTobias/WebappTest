package com.tobias.function.web.Admin;

import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserBan extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt af Show Users Chosen
         */

        String userID = request.getParameter("userid");
        String userBan = request.getParameter("userban");
        userFacade.updateUserBan(userID,userBan);
        return "admin/admininterface";
    }
}
