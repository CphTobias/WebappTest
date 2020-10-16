package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

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

        LogicFacade logicFacade = new LogicFacade();
        String userID = request.getParameter("userid");
        String userBan = request.getParameter("userban");
        logicFacade.updateUserBan(userID,userBan);
        return "admin/admininterface";
    }
}
