package com.tobias.function.layer;

import com.tobias.Database.DBController;
import com.tobias.Database.Handlers.UserHandler;
import com.tobias.Database.Mappers.UserMapper;
import com.tobias.function.entities.User.UserExists;
import com.tobias.function.entities.User.User;

public class LogicFacade {

    private static LogicFacade instance;

    public LogicFacade() {

    }

    /*public static LogicFacade getInstance() {
        if (instance == null) {
            try {
                WebAppRepository webApp = new DBController();
                instance = new LogicFacade(webApp);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        return instance;
    }*/

    private WebAppRepository webApp;

    private LogicFacade(WebAppRepository webApp) {
        this.webApp = webApp;
    }

    public User login(String name, String password) throws InvalidPassword {
        User user = webApp.findUser(name);
        if (user.isPasswordCorrect(password)) {
            return user;
        } else  {
            throw new InvalidPassword();
        }
    }
    /*public static User login(String username, String password) throws LoginSampleException {
        return UserMapper.login(username, password);
    }*/

    public User createUser(String name, String password) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return UserHandler.createUser(name, salt, secret);
    }
}
