package com.tobias.function.presentationlayer;

import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Admin.*;
import com.tobias.function.presentationlayer.Customer.ContactMessageMade;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put( "login", new Login() );
        commands.put( "register", new Register() );
        commands.put( "redirect", new Redirect() );
        commands.put("messageanswered", new MessageAnswered());
        commands.put("contactmessage", new ContactMessageMade());
        commands.put("addnewcar", new AddNewCar());
        commands.put("caravailable", new CarAvailable());
        commands.put("adminoptions", new AdminOptions());
        commands.put("updateuser", new UpdateUserRole());
        commands.put("showusers", new GetUser());
        commands.put("userbanned", new UpdateUserBan());
        commands.put("getadminrank", new GetAdminRank());
    }


    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }

    protected abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, ServletException, IOException;

}