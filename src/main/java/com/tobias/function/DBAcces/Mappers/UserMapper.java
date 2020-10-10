package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.layer.LoginSampleException;
import com.tobias.function.function.entities.User;

import java.sql.*;
import java.util.NoSuchElementException;

public class UserMapper {

    private static User loadUser(ResultSet rs) throws SQLException {
        return new User(
                rs.getInt("users.id"),
                rs.getString("users.name"),
                rs.getTimestamp("users.createdAt").toLocalDateTime(),
                rs.getBytes("users.salt"),
                rs.getBytes("users.secret"),
                rs.getString("users.role"));
    }

    public static User findUser(String name) throws NoSuchElementException {
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

    /*public static void createUser(User user) throws LoginSampleException {
        try {
            Connection con = Connector.getConnection();
            String SQL = "INSERT INTO users (username, password, role) VALUES (?, ?, ?)";
            PreparedStatement ps = con.prepareStatement( SQL, Statement.RETURN_GENERATED_KEYS );
            ps.setString( 1, user.getUsername() );
            ps.setString( 2, user.getPassword() );
            ps.setString( 3, user.getRole() );
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt( 1 );
            user.setId(id);
        } catch ( SQLException | ClassNotFoundException ex ) {
            throw new LoginSampleException( ex.getMessage() );
        }
    }*/

    /*public static User login(String username, String password) throws LoginSampleException {
        try {
            Connection con = Connector.getConnection();
            String SQL = "SELECT id, role FROM users "
                    + "WHERE username=? AND password=?";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString( 1, username );
            ps.setString( 2, password );
            ResultSet rs = ps.executeQuery();
            if ( rs.next() ) {
                String role = rs.getString( "role" );
                int id = rs.getInt( "id" );
                User user = new User(username, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginSampleException( "Could not validate user" );
            }
        } catch ( ClassNotFoundException | SQLException ex ) {
            throw new LoginSampleException(ex.getMessage());
        }
    }*/
}
