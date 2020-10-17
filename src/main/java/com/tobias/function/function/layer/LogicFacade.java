package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Handlers.CarHandler;
import com.tobias.function.DBAcces.Handlers.MessageHandler;
import com.tobias.function.DBAcces.Handlers.UserHandler;
import com.tobias.function.DBAcces.Mappers.CarMapper;
import com.tobias.function.DBAcces.Mappers.MessageMapper;
import com.tobias.function.DBAcces.Mappers.UserMapper;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.ContactMessage;
import com.tobias.function.function.entities.User;
import com.tobias.function.function.entities.UserExists;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

public class LogicFacade {

//---- USERS START ----

    /*
    Gets the name and password from Login.
    It tries to login with the given strings, using the UserHandler.
    Checks if the user is banned, if yes then it returns a string. If the user is not banned then it checks if the password was correct.
    If the password was correct it returns the user, if not correct it throws an InvalidPassword exception.
     */
    public User login(String name, String password) {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.findUser(name);
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
        UserHandler userHandler = new UserHandler();
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return userHandler.createUser(name, email, salt, secret);
    }

    /*
    Gets objects from UpdateUserRole.
    It calls the UserHandler which then updates the users role to given role
     */
    public void updateRole(String userName, String userRole, String userRank) {
        UserHandler userHandler = new UserHandler();
        int newRank = Integer.parseInt(userRank);
        try {
            userHandler.updateRole(userName, userRole, newRank);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Not called yet
     */
    public List<User> getAllUsers() {
        UserMapper userMapper = new UserMapper();
        List<User> users = userMapper.getAllUsers();
        return users;
    }

    /*
    Gets String from GetUser.
    Calls the UserMapper and finds the current users with the role of the given String.
    This is put into a List of Users, and returned.
     */
    public List<User> findChosenUsers(String userRole) {
        UserMapper userMapper = new UserMapper();
        List<User> userList = userMapper.findChosenUsers(userRole);
        return userList;
    }

    /*
    Gets the objects from UpdateUserBan.
    It calls the UserHandler, with the parsed Strings.
     */
    public void updateUserBan(String userID, String userBan) {
        UserHandler userHandler = new UserHandler();
        int getUserID = Integer.parseInt(userID);
        boolean getUserBanBoolean = Boolean.parseBoolean(userBan);

        try {
            userHandler.updateUserBan(getUserID, getUserBanBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//---- USERS END ----

//---- CARS START ----

    /*
    Gets the objects from AddNewCar.
    It calls the CarHandler to which the creates a new car with the given objects.
     */
    public void createCar(String horsepower, String brand, String price, String category, String model, String weight,
                          String buildYear, String milage, String image) {
        CarHandler carHandler = new CarHandler();

        int newhorsepower = Integer.parseInt(horsepower);
        double newprice = Double.parseDouble(price);
        int newweight = Integer.parseInt(weight);
        int newbuildyear = Integer.parseInt(buildYear);
        int newmilage = Integer.parseInt(milage);

        carHandler.createCar(newhorsepower,brand, newprice, category, model, newweight, newbuildyear, newmilage, image);
    }


    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
     */
    public void setCarToClosed(String carid, String caravailable) {
        CarHandler carHandler = new CarHandler();

        boolean getCarBoolean = Boolean.parseBoolean(caravailable);
        int getCarID = Integer.parseInt(carid);

        try {
            carHandler.setCarToClosed(getCarID, getCarBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
     */
    public void updatePrice(String carid, String newPrice) {
        CarHandler carHandler = new CarHandler();

        int getCarID = Integer.parseInt(carid);
        double getNewPrice = Double.parseDouble(newPrice);

        try {
            carHandler.updatePrice(getCarID, getNewPrice);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by AdminOptions (case "Manage Car Availability")
    It calls the CarMapper and returns a list of cars.
     */
    public List<Car> getAllCars() {
        CarMapper carMapper = new CarMapper();
        List<Car> cars = carMapper.getAllCars();
        return cars;
    }

//---- CARS END ----

//---- CONTACT MESSAGES START ----

    /*
    Called by ContactMessageMade with the given objects.
    It calls the MessageHandler to create a message and returns that contact message.
     */
    public ContactMessage createContactMessage(LocalDateTime now, String username, String email, String topic, String message) {
        MessageHandler messageHandler = new MessageHandler();
        ContactMessage cMessage = messageHandler.createContactMessage(LocalDateTime.now(),username, email, topic, message);
        return cMessage;
    }

    /*
    Called by AdminOptions (both the case "Active and Closed Messages".
    Calls the MessageMapper and and returns a list of contact messages with either closed or open messages.
     */
    public List<ContactMessage> getContactMessages(String username) {
        MessageMapper messageMapper = new MessageMapper();
        List<ContactMessage> cMessage = messageMapper.getContactMessages(username.equals("Closed Messages"));
        return cMessage;
    }

    /*
    Called by MessageAnswered with the given objects.
    It parses the strings and then calls the MessageHandler.
     */
    public void setMessageToClosed(String messageID, String messageAnswered) {
        MessageHandler messageHandler = new MessageHandler();
        boolean getMessageBoolean = Boolean.parseBoolean(messageAnswered);
        int getMessageID = Integer.parseInt(messageID);
        try {
            messageHandler.setMessageToClosed(getMessageID, getMessageBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

//---- CONTACT MESSAGES END ----
}
