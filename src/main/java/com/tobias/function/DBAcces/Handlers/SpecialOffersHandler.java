package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.DBAcces.Mappers.SpecialOffersMapper;
import com.tobias.function.function.entities.SpecialOffers;

import java.sql.*;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class SpecialOffersHandler {

    /*
    Called from the LogicFacade with a given int
    Deletes the Special Offer with the chosen offerID
     */
    public void deleteSpecialOffer(int newOfferID) {
        try (Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "DELETE FROM specialoffers WHERE carID = ?;");
            ps2.setInt(1, newOfferID);
            ps2.execute();
            ps2.close();
        } catch (SQLException | ClassNotFoundException se) {
            se.printStackTrace();
        }
    }

    /*

     */
    public SpecialOffers createSpecialOffer(int newCarID, String offer, String sideMessage) {
        SpecialOffersMapper specialOffersMapper = new SpecialOffersMapper();
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO specialoffers (carID,offer,sideMessage) " +
                                    "VALUE (?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, newCarID);
            ps.setString(2, offer);
            ps.setString(3, sideMessage);
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Car does not exist throw");;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return specialOffersMapper.findSpecialOffers(id);
    }
}