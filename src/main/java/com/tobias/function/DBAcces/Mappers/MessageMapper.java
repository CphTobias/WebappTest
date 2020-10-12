package com.tobias.function.DBAcces.Mappers;

import com.mysql.cj.x.protobuf.MysqlxPrepare;
import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.ContactMessage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class MessageMapper {

    private ContactMessage loadContactMessage(ResultSet rs) throws SQLException {
        return new ContactMessage(
                //int id, String name, String email, String message, boolean answered
                rs.getInt("contactmessages.id"),
                rs.getTimestamp("contactmessages.createdat").toLocalDateTime(),
                rs.getString("contactmessages.name"),
                rs.getString("contactmessages.email"),
                rs.getString("contactmessages.message"),
                rs.getBoolean("contactmessages.answered"));
    }

    public List<ContactMessage> getContactMessages(Boolean answered) {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM contactmessages WHERE answered = ?;");
            s.setBoolean(1, answered);
            ResultSet rs = s.executeQuery();
            ArrayList<ContactMessage> cmessages = new ArrayList<>();
            while (rs.next()) {
                cmessages.add(loadContactMessage(rs));
            }
            return cmessages;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public ContactMessage findContactMessage(int id) throws NoSuchElementException {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM contactmessages WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadContactMessage(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No msg with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public void setMessageToClosed(int messageID) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps1 = conn.prepareStatement(
                    "SELECT answered FROM contactmessages WHERE id=messageID"
            );
            ResultSet getMessage = ps1.executeQuery();
            if(!getMessage.getBoolean(1)){
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE contactmessages SET answered = 1 WHERE id = ?;");
                ps.setInt(1, messageID);
                ps.executeUpdate();
                ps.close();
            } else {
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE contactmessages SET answered = 0 WHERE id = ?;");
                ps.setInt(1, messageID);
                ps.executeUpdate();
                ps.close();
            }
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }
}