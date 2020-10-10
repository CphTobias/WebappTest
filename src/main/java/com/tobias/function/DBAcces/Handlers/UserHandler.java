package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.UserMapper;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;

import java.sql.*;

public class UserHandler {

    public static User createUser(String name, byte[] salt, byte[] secret) throws UserExists {
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
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return userMapper.findUser(id);
    }
}
