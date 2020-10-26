package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserBan extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt af Show Users Chosen
         */
        UserFactory userFactory = new UserFactory();
        try {
            userFactory.setId(request.getParameter("userid"));
            userFactory.setBanned(request.getParameter("userban"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(userFactory.isValid(userFactory)) {
            api.getUserFacade().updateUserBan(userFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal agrument was made");
            return "errors/errorpage";
        }
        return "admin/admininterface";
    }
}
