package com.tobias.function.function.entities;

import java.time.LocalDateTime;

public class ContactMessage {

    /*
    id INT PRIMARY KEY AUTO_INCREMENT,
    besvared BOOLEAN DEFAULT NULL,
    Navn VARCHAR(255) DEFAULT NULL,
    email VARCHAR(255) DEFAULT NULL,
    besked VARCHAR(255) DEFAULT NULL
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
        return "ContactMessage{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", message='" + message + '\'' +
                ", answered=" + answered +
                '}';
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
