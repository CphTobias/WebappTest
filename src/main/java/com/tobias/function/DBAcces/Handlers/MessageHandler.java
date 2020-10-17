package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.entities.ContactMessage;

import java.sql.*;
import java.time.LocalDateTime;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class MessageHandler {

    /*
    Creates a contact message in the database with the objects given from LogicFacade createContactMessage.
     */
    public ContactMessage createContactMessage(LocalDateTime time ,String name, String email, String topic, String message){
        MessageMapper mMapper = new MessageMapper();
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
        return mMapper.findContactMessage(id);
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
}
