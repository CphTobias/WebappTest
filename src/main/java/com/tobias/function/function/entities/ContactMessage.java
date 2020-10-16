package com.tobias.function.function.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class ContactMessage {

    /*
    id, createdAt and answered are automaticly set in the database.
     */
    private final int id;
    private final LocalDateTime createdAt;
    private final String name;
    private final String email;
    private final String message;
    private final boolean answered;

    public ContactMessage(int id, LocalDateTime createdAt, String name, String email, String message, boolean answered) {
        this.id = id;
        this.createdAt = createdAt;
        this.name = name;
        this.email = email;
        this.message = message;
        this.answered = answered;
    }

    @Override
    public String toString() {
        return  id +
                ". - " + createdAt +
                " - Name: " + name +
                " - Email: " + email +
                " - Message: " + message;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public boolean isAnswered() {
        return answered;
    }
}
