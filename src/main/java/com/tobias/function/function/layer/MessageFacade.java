package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Database.DBMessage;
import com.tobias.function.DBAcces.Database.DBUser;
import com.tobias.function.function.entities.ContactMessage;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class MessageFacade {

    private static MessageFacade instance;
    private final DBMessage dbMessage;

    public MessageFacade(DBMessage dbMessage) {
        this.dbMessage = dbMessage;
    }

    public static MessageFacade getInstance() {
        if (instance == null) {
            instance = new MessageFacade(new DBMessage());
        }
        return instance;
    }

    /*
    Called by ContactMessageMade with the given objects.
    It calls the MessageHandler to create a message and returns that contact message.
     */
    public ContactMessage createContactMessage(LocalDateTime now, String username, String email, String topic, String message) {
        ContactMessage cMessage = dbMessage.createContactMessage(LocalDateTime.now(),username, email, topic, message);
        return cMessage;
    }

    /*
    Called by AdminOptions (both the case "Active and Closed Messages".
    Calls the MessageMapper and and returns a list of contact messages with either closed or open messages.
     */
    public List<ContactMessage> getContactMessages(String username) {
        List<ContactMessage> cMessage = dbMessage.getContactMessages(username.equals("Closed Messages"));
        return cMessage;
    }

    /*
    Called by MessageAnswered with the given objects.
    It parses the strings and then calls the MessageHandler.
     */
    public void setMessageToClosed(String messageID, String messageAnswered) {
        boolean getMessageBoolean = Boolean.parseBoolean(messageAnswered);
        int getMessageID = Integer.parseInt(messageID);
        try {
            dbMessage.setMessageToClosed(getMessageID, getMessageBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
