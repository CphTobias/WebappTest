package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.MessageFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
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
        MessageFactory messageFactory = new MessageFactory();
        try {
            messageFactory.setId(request.getParameter("messages"));
            messageFactory.setAnswered(request.getParameter("answered"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(messageFactory.isValid(messageFactory)) {
            api.getMessageFacade().setMessageToClosed(messageFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }
        return "admin/admininterface";
    }
}
