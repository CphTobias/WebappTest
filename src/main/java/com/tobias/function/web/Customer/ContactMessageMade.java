package com.tobias.function.web.Customer;

import com.tobias.function.api.factories.MessageFactory;
import com.tobias.function.domain.ContactMessage;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.web.Command;

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
        MessageFactory messageFactory = new MessageFactory();
        messageFactory.setName(request.getParameter("name"));
        messageFactory.setTopic(request.getParameter("topic"));
        messageFactory.setEmail(request.getParameter("email"));
        messageFactory.setMessage(request.getParameter("message"));

        if(messageFactory.isValid(messageFactory)) {
            ContactMessage cMessage = api.getMessageFacade().createContactMessage(LocalDateTime.now(), messageFactory);

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
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "Failed to update user");
            return "errors/errorpage";
        }
    }
}
