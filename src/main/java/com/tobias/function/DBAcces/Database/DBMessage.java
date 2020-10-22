package com.tobias.function.DBAcces.Database;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.ContactMessage;

import java.sql.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class DBMessage {

    /*
    Creates a contact message in the database with the objects given from LogicFacade createContactMessage.
     */
    public ContactMessage createContactMessage(LocalDateTime time , String name, String email, String topic, String message){
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO contactmessages (createdat, name, email, topic, message) " +
                                    "VALUE (?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(time));
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, topic);
            ps.setString(5, message);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Message does not exist throw");;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return findContactMessage(id);
    }

    /*
    Gets the id of a contact message and the current state of whether the message is answered or not, from LogicFacade setMessageToClosed.
    It then either opens or closes the contact message.
     */
    public void setMessageToClosed(int messageID, boolean getMessageBoolean) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            if(getMessageBoolean == false){
                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE contactmessages SET answered = 1 WHERE id = ?;");
                ps2.setInt(1, messageID);
                ps2.executeUpdate();
                ps2.close();
            } else {
                PreparedStatement ps3 = conn.prepareStatement(
                        "UPDATE contactmessages SET answered = 0 WHERE id = ?;");
                ps3.setInt(1, messageID);
                ps3.executeUpdate();
                ps3.close();
            }
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    /*
   Is used to call from methods, where you want to get a contact message object.
    */
    private ContactMessage loadContactMessage(ResultSet rs) throws SQLException {
        return new ContactMessage(
                //int id, String name, String email, String message, boolean answered
                rs.getInt("contactmessages.id"),
                rs.getTimestamp("contactmessages.createdat").toLocalDateTime(),
                rs.getString("contactmessages.name"),
                rs.getString("contactmessages.email"),
                rs.getString("contactmessages.topic"),
                rs.getString("contactmessages.message"),
                rs.getBoolean("contactmessages.answered"));
    }

    /*
    Gets the boolean from LogicFacade getContactMessages.
    It finds all the current messages that are either false or true, depending on the given boolean.
     */
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

    /*
    Gets the id from LogicFacade findContactMessage.
    It finds a specific contact message, specified by the given id.
     */
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
}
