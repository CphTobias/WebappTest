package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.UserMapper;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;
import com.tobias.function.function.layer.LoginSampleException;

import java.sql.*;

public class UserHandler {

    /*
        Creates a user in the database with the objects given from LogicFacade createUser.
    */
    public User createUser(String name, byte[] salt, byte[] secret) throws UserExists {
        UserMapper userMapper = new UserMapper();
        int id;
        try (Connection conn = Connector.getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO users (name, salt, secret, role) " +
                                    "VALUE (?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, name);
            ps.setBytes(2, salt);
            ps.setBytes(3, secret);
            ps.setString( 4, "customer");
            try {
                ps.executeUpdate();
            } catch (SQLIntegrityConstraintViolationException e) {
                throw new UserExists(name);
            }

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                throw new UserExists(name);
            }
        } catch (SQLException | ClassNotFoundException | LoginSampleException e) {
            throw new RuntimeException(e);
        }
        return userMapper.findUser(id);
    }

    /*
    Get the role and id from LogicFacade updateRole
    It updates the role of a user
     */
    public void updateRole(String userName, String userRole) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE users SET role = ? WHERE name = ?;");
            ps2.setString(1, userRole);
            ps2.setString(2, userName);
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
}
