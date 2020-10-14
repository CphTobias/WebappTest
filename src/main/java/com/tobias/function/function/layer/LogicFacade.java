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

    public User login(String name, String password) throws InvalidPassword {
        UserMapper userMapper = new UserMapper();
        User user = userMapper.findUser(name);
        if (user.isPasswordCorrect(password)) {
            return user;
        } else  {
            throw new InvalidPassword();
        }
    }

    public User createUser(String name, String password) throws UserExists {
        UserHandler userHandler = new UserHandler();
        byte[] salt = User.generateSalt();
        byte[] secret = User.calculateSecret(salt, password);
        return userHandler.createUser(name, salt, secret);
    }


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

    public ContactMessage createContactMessage(LocalDateTime now, String username, String email, String message) {
        MessageHandler messageHandler = new MessageHandler();
        ContactMessage cMessage = messageHandler.createContactMessage(LocalDateTime.now(),username, email, message);
        return cMessage;
    }

    public List<Car> getAllCars() {
        CarMapper carMapper = new CarMapper();
        List<Car> cars = carMapper.getAllCars();
        return cars;
    }

    public List<ContactMessage> getContactMessages(String username) {
        MessageMapper messageMapper = new MessageMapper();
        List<ContactMessage> cMessage = messageMapper.getContactMessages(username.equals("Closed Messages"));
        return cMessage;
    }

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
}
