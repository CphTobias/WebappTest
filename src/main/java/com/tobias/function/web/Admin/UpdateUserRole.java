package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;
import com.tobias.function.web.Command;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateUserRole extends Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {

        /*
        Bliver kaldt af FrontControlleren, som kom fra admininterface.
        Bliver kaldt fra Update User Role
         */
        UserFactory userFactory = new UserFactory();
        try {
            userFactory.setName(request.getParameter("username"));
            userFactory.setRole(request.getParameter("userrole"));
            userFactory.setRanked(request.getParameter("userrank"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(userFactory.isValid(userFactory)) {
            api.getUserFacade().updateRole(userFactory);
            return "admin/admininterface";
        } else {                                
        }
    }
}
