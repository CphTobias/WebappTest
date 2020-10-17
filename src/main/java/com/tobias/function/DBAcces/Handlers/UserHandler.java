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
    public User createUser(String name, String email, byte[] salt, byte[] secret) throws UserExists {
        UserMapper userMapper = new UserMapper();
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
}
