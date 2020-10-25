package com.tobias.function.infrastructure.Database;

import com.tobias.function.infrastructure.DBSetup.Connector;
import com.tobias.function.domain.User;
import com.tobias.function.exceptions.UserExists;
import com.tobias.function.exceptions.LoginSampleException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.infrastructure.DBSetup.Connector.getConnection;

public class DBUser {

    /*
        Creates a user in the database with the objects given from LogicFacade createUser.
    */
    public User createUser(String name, String email, byte[] salt, byte[] secret) {
        int id;
        try (Connection conn = Connector.getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO users (name, email, salt, secret, role) " +
                                    "VALUE (?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setString(2, email);
            ps.setBytes(3, salt);
            ps.setBytes(4, secret);
            ps.setString( 5, "customer");
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                e.printStackTrace();
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new SQLException();
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return findUser(id);
    }

    /*
    Get the role and id from LogicFacade updateRole
    It updates the role of a user
     */
    public void updateRole(String userName, String userRole, int userRank) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE users SET role = ?, ranked = ? WHERE name = ?;");
            ps2.setString(1, userRole);
            ps2.setInt(2, userRank);
            ps2.setString(3, userName);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    /*
    Gets the id and whether the user is currently banned or not from LogicFacade updateUserBan.
    It sets the user to either banned or not banned.
     */
    public void updateUserBan(int getUserID, boolean getUserBanBoolean) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            if(getUserBanBoolean == false){
                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE users SET banned = 1 WHERE id = ?;");
                ps2.setInt(1, getUserID);
                ps2.executeUpdate();
                ps2.close();
            } else {
                PreparedStatement ps3 = conn.prepareStatement(
                        "UPDATE users SET banned = 0 WHERE id = ?;");
                ps3.setInt(1, getUserID);
                ps3.executeUpdate();
                ps3.close();
            }
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    /*
    Is used to call from methods, where you want to get a user object.
    */
    private User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("users.id"),
                rs.getString("users.name"),
                rs.getString("users.email"),
                rs.getTimestamp("users.createdAt").toLocalDateTime(),
                rs.getBytes("users.salt"),
                rs.getBytes("users.secret"),
                rs.getString("users.role"),
                rs.getDouble("users.bank"),
                rs.getBoolean("users.banned"),
                rs.getInt("users.ranked"));
    }

    /*
    Finds all the current users in the database, is called from LogicFacade getAllUsers.
     */
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

    /*
    String users is given from LogicFacade findChosenUsers.
    It finds the users from a specific role, specified by the string.
     */
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

    /*
    String name is given from LogicFacade findUser(String name).
    It finds a specific user, by the users name.
     */
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

    /*
    int id is given from LogicFacade findUser(int id)
    It finds a specific user, by the users id.
     */
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

    public User updateUserBank(String username, double newBank) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE users SET bank = ? WHERE name = ?;");
            ps2.setDouble(1, newBank);
            ps2.setString(2, username);
            ps2.executeUpdate();
            ps2.close();
        }
        return findUser(username);
    }
}
