package com.tobias.function.presentationlayer.Admin;

import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class GetAdminRank extends com.tobias.function.presentationlayer.Command {
    @Override
    protected String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, ServletException, IOException {
        String ranked = request.getParameter("ranked");
        int newRanked = Integer.parseInt(ranked);
        if (newRanked <= 10){
            request.setAttribute("rank10", ranked);
        } else if (newRanked <= 50){
            request.setAttribute("rank50", ranked);
        } else {
            request.setAttribute("rank99", ranked);
        }

        return "admin/admininterface";
    }
}
