package com.tobias.function.web.Admin;

import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class MessageAnswered extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt af Show Messages
         */

        String messageID = request.getParameter("messages");
        String messageAnswered = request.getParameter("answered");

        api.getMessageFacade().setMessageToClosed(messageID, messageAnswered);

        return "admin/admininterface";
    }
}
