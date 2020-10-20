package com.tobias.function.presentationlayer;

import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.presentationlayer.Admin.*;
import com.tobias.function.presentationlayer.Customer.AddToOrder;
import com.tobias.function.presentationlayer.Customer.ContactMessageMade;
import com.tobias.function.presentationlayer.Customer.GetAllCars;
import com.tobias.function.presentationlayer.Customer.GetBasket;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

public abstract class Command {

    private static HashMap<String, Command> commands;

    /*
    Sets the commads that are called in the jsp files.
     */
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
        commands.put("logoutuser", new Logout());
        commands.put("closeoffer", new CloseOffer());
        commands.put("addspecialoffer", new CreateSpecialOffer());
        commands.put("getallcars", new GetAllCars());
        commands.put("addtoorder", new AddToOrder());
        commands.put("getbasket", new GetBasket());
    }

    /*
    if the value target is called in the jsp files this is called.
    If a command doesnt exist it calls UnknownCommand
     */
    static Command from( HttpServletRequest request ) {
        String targetName = request.getParameter( "target" );
        if ( commands == null ) {
            initCommands();
        }
        return commands.getOrDefault(targetName, new UnknownCommand() );   // unknowncommand er default.
    }


    /*
    This is the abstract method that is needed in all of our classes created by initCommands();
     */
    protected abstract String execute(HttpServletRequest request, HttpServletResponse response)
            throws LoginSampleException, ServletException, IOException;

}