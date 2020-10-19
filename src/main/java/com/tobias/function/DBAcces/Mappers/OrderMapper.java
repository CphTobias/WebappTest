package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class OrderMapper {

    private Order loadOrder(ResultSet rs) throws SQLException {
        /*
        private final int id;
    private final int userID;
    private final String carID;
    private final boolean paid;
         */
        return new Order(
                rs.getInt("orders.id"),
                rs.getInt("orders.userid"),
                rs.getString("orders.carid"),
                rs.getBoolean("orders.paid"));
    }

    public Order findPreOrder(int newUserID) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE userid = ? AND paid = 0;");
            s.setInt(1, newUserID);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadOrder(rs);
            } else {
                return null;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Order findOrder(int id) {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM orders WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadOrder(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No order with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
