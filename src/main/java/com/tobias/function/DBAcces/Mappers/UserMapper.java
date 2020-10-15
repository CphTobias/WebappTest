package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.User;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class UserMapper {

    public List<User> getAllUsers() {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM users;");
            ResultSet rs = s.executeQuery();
            ArrayList<User> users = new ArrayList<>();
            while(rs.next()) {
                users.add(loadUser(rs));
            }
            return users;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<User> findChosenUsers(String users) throws NoSuchElementException {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM users WHERE role = ?;");
            s.setString(1, users);
            ResultSet rs = s.executeQuery();
            ArrayList<User> userArray = new ArrayList<>();
            while (rs.next()) {
                userArray.add(loadUser(rs));
            }
            return userArray;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    private User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("users.id"),
                rs.getString("users.name"),
                rs.getTimestamp("users.createdAt").toLocalDateTime(),
                rs.getBytes("users.salt"),
                rs.getBytes("users.secret"),
                rs.getString("users.role"),
                rs.getBoolean("users.banned"),
                rs.getInt("users.ranked"));
    }

    public User findUser(String name) throws NoSuchElementException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM users WHERE name = ?;");
            s.setString(1, name);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadUser(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException(name);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public User findUser(int id) throws NoSuchElementException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM users WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadUser(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No user with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
