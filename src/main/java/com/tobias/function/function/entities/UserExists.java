package com.tobias.function.function.entities;

public class UserExists extends Exception {
    public UserExists(String name) {
        super("User already exists: " + name);
    }
}