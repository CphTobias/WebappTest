package com.tobias.function.api.factories;

import com.tobias.function.exceptions.ValidationError;

import java.time.LocalDateTime;

public class MessageFactory {

    /*
    private final int id;
    private final LocalDateTime createdAt;
    private final String name;
    private final String email;
    private final String topic;
    private final String message;
    private final boolean answered;
     */

    private int id;
    private LocalDateTime createdAt;
    private String name;
    private String email;
    private String topic;
    private String message;
    private boolean answered;

    public boolean isValid(MessageFactory messageFactory) {
        return messageFactory != null;
    }

    public void setId(int id) throws ValidationError {
        if(id < 0) throw new ValidationError("The id cannot be less than 0");
        this.id = id;
    }

    public void setId(String number) throws ValidationError{
        try {
            setId(Integer.parseInt(number));
        } catch (NumberFormatException e){
            throw new ValidationError(e.toString());
        }
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public void setCreatedAt(String ldt) throws ValidationError {
        try {
            setCreatedAt(LocalDateTime.parse(ldt));
        } catch (NumberFormatException e) {
            throw new ValidationError(e.toString());
        }
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public void setAnswered(boolean answered) {
        this.answered = answered;
    }

    public void setAnswered(String answered) throws ValidationError {
        try {
            setAnswered(answered.equals("1") || answered.equals("true"));
        } catch (IllegalArgumentException e) {
            throw new ValidationError(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getTopic() {
        return topic;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAnswered() {
        return answered;
    }
}
