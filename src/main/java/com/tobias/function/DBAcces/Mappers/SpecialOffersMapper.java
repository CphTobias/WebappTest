package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.SpecialOffers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class SpecialOffersMapper {

    /*
    Is used to call from methods, where you want to get a SpecialOffers object.
     */
    //int id, int carID, String carImage, String offer, String sideMessage
    private SpecialOffers loadSpecialOffers(ResultSet rs) throws SQLException {
        return new SpecialOffers(
                rs.getInt("specialoffers.id"),
                rs.getInt("specialoffers.carID"),
                rs.getString("specialoffers.offer"),
                rs.getString("specialoffers.sideMessage"));
    }

    /*
    Finds the special offers from the database and returns them in a list of SpecialOffers
     */
    public List<SpecialOffers> findSpecialOffers() {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM specialoffers;");
            ResultSet rs = s.executeQuery();
            ArrayList<SpecialOffers> specialOffers = new ArrayList<>();
            while(rs.next()) {
                specialOffers.add(loadSpecialOffers(rs));
            }
            return specialOffers;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
