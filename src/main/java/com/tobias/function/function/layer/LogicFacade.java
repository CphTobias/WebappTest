package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Handlers.UserHandler;
import com.tobias.function.DBAcces.Mappers.UserMapper;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;

public class LogicFacade {

    public static User login(String name, String password) throws InvalidPassword {
        User user = UserMapper.findUser(name);
        if (user.isPasswordCorrect(password)) {
            return user;
        } else  {
            throw new InvalidPassword();
        }
    }

    public static User createUser(String name, String password) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return UserHandler.createUser(name, salt, secret);
    }


}
