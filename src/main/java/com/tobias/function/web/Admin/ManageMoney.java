package com.tobias.function.web.Admin;

import com.tobias.function.exceptions.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ManageMoney extends com.tobias.function.web.Command {

    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String username = request.getParameter("name");
        String amount = request.getParameter("amount");
        String answer = request.getParameter("moneyans");
        String userbank = request.getParameter("userbank");
        double newAmount = Double.parseDouble(amount);
        double newUserBank = Double.parseDouble(userbank);

        /*
        Checks if the answer was Add money or Take money, if add then it will plus the current bank together with the added amount, if not it will minus the
        current current amount with the taken amount.
         */
        if (answer.equals("add")){
            double add = newAmount + newUserBank;
            api.getUserFacade().updateUserBank(username,add);
        } else {
            double remove = newUserBank - newAmount;
            if (remove < 0) {
                remove = 0;
            }
            api.getUserFacade().updateUserBank(username,remove);
        }

        return "admin/admininterface";
    }
}
