package com.tobias.function.api.facades;

import com.tobias.function.api.factories.MessageFactory;
import com.tobias.function.domain.ContactMessage;
import com.tobias.function.infrastructure.Database.DBMessage;

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
    public ContactMessage createContactMessage(LocalDateTime now, MessageFactory messageFactory) {
        ContactMessage cMessage = dbMessage.createContactMessage(LocalDateTime.now(), messageFactory);
        return cMessage;
    }

    /*
    Called by AdminOptions (both the case "Active and Closed Messages".
    Calls the MessageMapper and and returns a list of contact messages with either closed or open messages.
     */
    public List<ContactMessage> getContactMessages(String username) {
        return dbMessage.getContactMessages(username.equals("Closed Messages"));
    }

    /*
    Called by MessageAnswered with the given objects.
    It parses the strings and then calls the MessageHandler.
     */
    public void setMessageToClosed(MessageFactory messageFactory) {
        try {
            dbMessage.setMessageToClosed(messageFactory.getId(), messageFactory.isAnswered());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
