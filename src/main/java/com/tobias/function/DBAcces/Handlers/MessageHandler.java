package com.tobias.function.DBAcces.Handlers;

import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.function.entities.ContactMessage;

import java.sql.*;
import java.time.LocalDateTime;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class MessageHandler {

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

    public ContactMessage createContactMessage(LocalDateTime time ,String name, String email, String message){
        MessageMapper mMapper = new MessageMapper();
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO contactmessages (createdat, name, email, message) " +
                                    "VALUE (?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setTimestamp(1, Timestamp.valueOf(time));
            ps.setString(2, name);
            ps.setString(3, email);
            ps.setString(4, message);
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
}
