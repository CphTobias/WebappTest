package com.tobias.function.layer;

import com.tobias.DBAcces.Handlers.UserHandler;
import com.tobias.DBAcces.Mappers.UserMapper;
import com.tobias.function.entities.User.UserExists;
import com.tobias.function.entities.User.User;

public class LogicFacade {

    public static User login(String name, String password) throws InvalidPassword {
        UserMapper userMapper = new UserMapper();
        User user = UserMapper.findUser(name);
        if (user.isPasswordCorrect(password)) {
            return user;
        } else  {
            throw new InvalidPassword();
        }
    }
    /*public static User login(String username, String password) throws LoginSampleException {
        return UserMapper.login(username, password);
    }*/

    public static User createUser(String name, String password) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return UserHandler.createUser(name, salt, secret);
    }
}
