package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SpecialOffersHandler {

    public void deleteSpecialOffer(int newOfferID) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "DELETE specialoffers WHERE id = ?;");
            ps2.setInt(1, newOfferID);
            ps2.execute();
            ps2.close();
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }
}
