package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MessageAnswered extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        LogicFacade logicFacade = new LogicFacade();

        String messageID = request.getParameter("messages");
        String messageAnswered = request.getParameter("answered");

        logicFacade.setMessageToClosed(messageID, messageAnswered);

        return "admininterface";
    }
}
