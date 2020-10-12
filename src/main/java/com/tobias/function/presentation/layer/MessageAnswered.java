package com.tobias.function.presentation.layer;

import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class MessageAnswered extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        MessageMapper messageMapper = new MessageMapper();
        String username = request.getParameter("messages");

        int getmessage = Integer.parseInt(username);

        try {
            messageMapper.setMessageToClosed(getmessage);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return "adminpage";
    }
}