package com.tobias.function.presentation.layer;

import com.tobias.function.DBAcces.Handlers.MessageHandler;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ContactMessageMade extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        MessageHandler messageHandler = new MessageHandler();
        String username = request.getParameter("name");
        String email = request.getParameter("email");
        String message = request.getParameter("message");
        String time = LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:MM"));

        ContactMessage cMessage = messageHandler.createContactMessage(LocalDateTime.now(),username, email, message);

        String formatedTime = " " + cMessage.getCreatedAt().format(DateTimeFormatter.ISO_LOCAL_TIME);
        String formatedName = " " + cMessage.getName();
        String formatedEmail = " " + cMessage.getEmail();
        String formatedCMessage = " " + cMessage.getMessage();

        request.setAttribute("time", formatedTime);
        request.setAttribute("name", formatedName);
        request.setAttribute("email", formatedEmail);
        request.setAttribute("message", formatedCMessage);

        return "ContactMessageSend";
    }
}
