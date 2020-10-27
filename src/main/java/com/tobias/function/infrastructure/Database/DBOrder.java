package com.tobias.function.infrastructure.Database;

import com.tobias.function.api.factories.OrderFactory;
import com.tobias.function.infrastructure.DBSetup.Connector;
import com.tobias.function.domain.Order;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.infrastructure.DBSetup.Connector.getConnection;

public class DBOrder {

    public Order createOrder(int userID) {
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
        return findOrder(id);
    }

    public void updatePreOrder(String carID, int userID) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE orders SET carid = ? WHERE userid = ? AND paid = 0;");
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
                rs.getBoolean("orders.paid"),
                rs.getInt("orders.price"),
                rs.getTimestamp("orders.paidat").toLocalDateTime());
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

    public Order orderPurchased(OrderFactory orderFactory, int id) {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE orders SET paid = 1, price = ?, paidat = ? WHERE userid = ?;");
            ps2.setDouble(1, orderFactory.getPrice());
            ps2.setTimestamp(2, Timestamp.valueOf(LocalDateTime.now()));
            ps2.setInt(3, orderFactory.getUserID());
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return findOrder(id);
    }

    public List<Order> getUserOrders(int newUserID) {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM orders WHERE userid = ?;");
            s.setInt(1, newUserID);
            ResultSet rs = s.executeQuery();
            ArrayList<Order> orders = new ArrayList<>();
            while(rs.next()) {
                orders.add(loadOrder(rs));
            }
            return orders;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
