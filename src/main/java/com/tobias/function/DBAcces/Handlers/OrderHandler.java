package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.DBAcces.Mappers.OrderMapper;
import com.tobias.function.function.entities.Order;

import java.sql.*;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class OrderHandler {

    public Order createOrder(int userID) {
        OrderMapper orderMapper = new OrderMapper();
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO orders (userid) " +
                                    "VALUE (?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, userID);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Order does not exist throw");;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return orderMapper.findOrder(id);
    }

    public void updatePreOrder(String carID, int userID) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE orders SET carid = ? WHERE userid = ?;");
            ps2.setString(1, carID);
            ps2.setInt(2, userID);
            ps2.executeUpdate();
            ps2.close();
        }
    }

    public void deletePreOrder(int newUserID) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "DELETE FROM orders WHERE userid = ? AND paid = 0;");
            ps2.setInt(1, newUserID);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
