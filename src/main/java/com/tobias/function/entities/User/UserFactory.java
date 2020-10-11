package com.tobias.function.entities.User;

public interface UserFactory {
    User createUser(String name, byte[] salt, byte[] secret) throws UserExists;
}
