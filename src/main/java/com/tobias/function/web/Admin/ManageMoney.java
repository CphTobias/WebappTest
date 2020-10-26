package com.tobias.function.web.Admin;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.exceptions.LoginSampleException;
import com.tobias.function.exceptions.ValidationError;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManageMoney extends com.tobias.function.web.Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        UserFactory userFactory = new UserFactory();

        try {
            userFactory.setName(request.getParameter("name"));
            userFactory.setAnswer(request.getParameter("moneyans"));
            userFactory.setBank(request.getParameter("amount"), request.getParameter("userbank"));
        } catch (ValidationError validationError) {
            validationError.printStackTrace();
        }

        if(userFactory.isValid(userFactory)) {
            api.getUserFacade().updateUserBank(userFactory);
        } else {
            request.setAttribute("error400", "400");
            request.setAttribute("error", "An illigal input was made");
            return "errors/errorpage";
        }

        return "admin/admininterface";
    }
}
