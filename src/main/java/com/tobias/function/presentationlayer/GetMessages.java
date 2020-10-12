package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

public class GetMessages extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        MessageMapper messageMapper = new MessageMapper();
        String username = request.getParameter("messages");

        List<ContactMessage> cMessage = messageMapper.getContactMessages(username.equals("Closed Messages"));

        for (ContactMessage c: cMessage) {
            messageMapper.findContactMessage(c.getId());
        }

        request.setAttribute("activeCM", cMessage);

        return "adminpage";
    }
}
