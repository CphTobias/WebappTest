package com.tobias.function.infrastructure.Database;

import com.tobias.function.infrastructure.DBSetup.Connector;
import com.tobias.function.domain.SpecialOffers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.infrastructure.DBSetup.Connector.getConnection;

public class DBSpecialOffers {

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
        return findSpecialOffers(id);
    }

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

    public SpecialOffers findSpecialOffers(int id) throws NoSuchElementException {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM specialoffers WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadSpecialOffers(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No specialoffer with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
