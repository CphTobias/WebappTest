package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Database.DBUser;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;

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
    public User login(String name, String password) {
        User user = dbUser.findUser(name);
        if(user.isBanned()){
            user = null;
            return user;
        } else {
            if (user.isPasswordCorrect(password)) {
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
    public User createUser(String name, String email, String password) throws UserExists {
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return dbUser.createUser(name, email, salt, secret);
    }

    /*
    Gets objects from UpdateUserRole.
    It calls the UserHandler which then updates the users role to given role
     */
    public void updateRole(String userName, String userRole, String userRank) {
        int newRank = Integer.parseInt(userRank);
        try {
            dbUser.updateRole(userName, userRole, newRank);
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
        List<User> userList = dbUser.findChosenUsers(userRole);
        return userList;
    }

    /*
    Gets the objects from UpdateUserBan.
    It calls the UserHandler, with the parsed Strings.
     */
    public void updateUserBan(String userID, String userBan) {
        int getUserID = Integer.parseInt(userID);
        boolean getUserBanBoolean = Boolean.parseBoolean(userBan);

        try {
            dbUser.updateUserBan(getUserID, getUserBanBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public User findUser(String userID){
        int newUserID = Integer.parseInt(userID);
        User tempUser = dbUser.findUser(newUserID);
        return tempUser;
    }
}
