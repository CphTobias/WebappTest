package com.tobias.function.presentationlayer;

import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.layer.LoginSampleException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

public class CarAvailable extends Command {
    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginSampleException, LoginSampleException, ServletException, IOException {
        CarMapper carMapper = new CarMapper();
        String carid = request.getParameter("carid");
        String caravailable = request.getParameter("caravailable");
        String newPrice = request.getParameter("changeprice");
        String newerPrice = newPrice;

        boolean getCarBoolean = Boolean.parseBoolean(caravailable);
        int getCarID = Integer.parseInt(carid);

        if(newPrice.chars().findAny().isPresent()){
            try {
                double getNewPrice = Double.parseDouble(newerPrice);
                carMapper.setCarToClosed(getCarID, getCarBoolean);
                carMapper.updatePrice(getCarID, getNewPrice);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        } else {
            try {
                carMapper.setCarToClosed(getCarID, getCarBoolean);
            } catch (SQLException | ClassNotFoundException throwables) {
                throwables.printStackTrace();
            }
        }

        return "admininterface";
    }
}
