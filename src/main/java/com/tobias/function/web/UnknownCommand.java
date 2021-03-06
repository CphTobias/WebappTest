package com.tobias.function.web;

import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 The purpose of UnknownCommand is to...

 @author kasper
 */
public class UnknownCommand extends Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException {
        String msg = "Unknown command. Contact IT :)";
        throw new LoginSampleException(msg);
    }

}
