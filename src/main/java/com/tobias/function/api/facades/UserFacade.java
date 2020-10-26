package com.tobias.function.api.facades;

import com.tobias.function.api.factories.UserFactory;
import com.tobias.function.domain.User;
import com.tobias.function.infrastructure.Database.DBUser;
import com.tobias.function.exceptions.UserExists;

import java.sql.SQLException;
import java.util.List;

public class UserFacade {

    private static UserFacade instance;

    public UserFacade(DBUser dbUser) {
        this.dbUser = dbUser;
    }

    public static UserFacade getInstance() {
        if (instance == null) {
            instance = new UserFacade(new DBUser());
        }
        return instance;
    }

    private final DBUser dbUser;

    /*
    Gets the name and password from Login.
    It tries to login with the given strings, using the UserHandler.
    Checks if the user is banned, if yes then it returns a string. If the user is not banned then it checks if the password was correct.
    If the password was correct it returns the user, if not correct it throws an InvalidPassword exception.
     */
    public User login(UserFactory userFactory) {
        User user = dbUser.findUser(userFactory.getName());
        if(user.isBanned()){
            user = null;
            return user;
        } else {
            if (user.isPasswordCorrect(userFactory.getPassword())) {
                return user;
            } else {
                user = null;
                return user;
            }
        }
    }

    /*
    Gets the name and password from Register.
    It tries returning a created new user in the database using the UserHandler.
    It is returned due to the user getting logged in after it is created.
    if the user did not get made, it will throw a UserExists exception.
     */
    public User createUser(UserFactory userFactory) {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, userFactory.getPassword());
        return dbUser.createUser(userFactory.getName(), userFactory.getEmail(), salt, secret);
    }

    /*
    Gets objects from UpdateUserRole.
    It calls the UserHandler which then updates the users role to given role
     */
    public void updateRole(UserFactory userFactory) {
        try {
            dbUser.updateRole(userFactory.getName(), userFactory.getRole(), userFactory.getRanked());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Not called yet
     */
    public List<User> getAllUsers() {
        List<User> users = dbUser.getAllUsers();
        return users;
    }

    /*
    Gets String from GetUser.
    Calls the UserMapper and finds the current users with the role of the given String.
    This is put into a List of Users, and returned.
     */
    public List<User> findChosenUsers(String userRole) {
        return dbUser.findChosenUsers(userRole);
    }

    /*
    Gets the objects from UpdateUserBan.
    It calls the UserHandler, with the parsed Strings.
     */
    public void updateUserBan(UserFactory userFactory) {
        try {
            dbUser.updateUserBan(userFactory.getId(), userFactory.isBanned());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findUser(String userID){
        int newUserID = Integer.parseInt(userID);
        return dbUser.findUser(newUserID);
    }

    public User findUserName(String userName){
        User tempUser = dbUser.findUser(userName);
        return tempUser;
    }

    /*
    Updates the users bank.
    Called by ManageMoney, and calls the DBUser.
     */
    public User updateUserBank(String username, double newBank) {
        User retUser = null;
        try {
            retUser = dbUser.updateUserBank(username, newBank);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
        return retUser;
    }
}
