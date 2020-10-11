package com.tobias.function.entities.User;

public class UserExists extends Exception {
    public UserExists(String name) {
        super("User already exists: " + name);
    }
}