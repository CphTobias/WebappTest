package com.tobias.function.presentationlayer.Customer;

import com.tobias.function.DBAcces.Handlers.MessageHandler;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.layer.LogicFacade;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContactMessageMade extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Called when creating a contact message. It calls the logicfacade to create a contact message.
         */

        LogicFacade logicFacade = new LogicFacade();

        String username = request.getParameter("name");
        String topic = request.getParameter("topic");
        String email = request.getParameter("email");
        String message = request.getParameter("message");

        ContactMessage cMessage = logicFacade.createContactMessage(LocalDateTime.now(),username, email,topic, message);

        String formatedTime = " " + cMessage.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_TIME);
        String formatedName = " " + cMessage.getName();
        String formatedEmail = " " + cMessage.getEmail();
        String formatedCMessage = " " + cMessage.getMessage();
        String formatedTopic = " " + cMessage.getTopic();

        request.setAttribute("topic", formatedTopic);
        request.setAttribute("time", formatedTime);
        request.setAttribute("name", formatedName);
        request.setAttribute("email", formatedEmail);
        request.setAttribute("message", formatedCMessage);

        return "customer/ContactMessageSend";
    }
}
