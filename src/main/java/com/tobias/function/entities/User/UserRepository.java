package com.tobias.function.entities.User;

public interface UserRepository extends UserFactory {
    User findUser(String name);
    User findUser(int id);
}
