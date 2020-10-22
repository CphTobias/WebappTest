package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Database.DBCar;
import com.tobias.function.DBAcces.Database.DBOrder;
import com.tobias.function.DBAcces.Database.DBUser;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.Order;

import java.sql.SQLException;
import java.util.ArrayList;

public class OrderFacade {

    private static OrderFacade instance;

    private final DBOrder dbOrder;

    public OrderFacade(DBOrder dbOrder) {
        this.dbOrder = dbOrder;
    }

    public static OrderFacade getInstance() {
        if (instance == null) {
            instance = new OrderFacade(new DBOrder());
        }
        return instance;
    }

    public Order createOrder(String userID) {
        int newUserID = Integer.parseInt(userID);
        Order order = dbOrder.createOrder(newUserID);
        return order;
    }

    /*
    Called by AddToOrder. It parses the string to an integer and then calls the ordermapper to find a preorder
    returns either null or an order.
     */
    public Order findPreOrder(String userID) {
        int newUserID = Integer.parseInt(userID);
        Order tempOrder = dbOrder.findPreOrder(newUserID);
        return tempOrder;
    }

    /*
    Called by AddToOrder. It parses the string userID to and integer then calls the orderhandler to update the carid.
     */
    public void updatePreOrder(String carID, String userID) {
        int newUserID = Integer.parseInt(userID);
        try {
            dbOrder.updatePreOrder(carID, newUserID);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by AddToOrder. It parses the string userID to and integer then calls the orderhandler to update the carid.
     */
    public void updatePreOrder(String carIDs, String carID, String userID) {
        int newUserID = Integer.parseInt(userID);
        String newCarID = carIDs + carID;
        try {
            dbOrder.updatePreOrder(newCarID, newUserID);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Order getPreOrder(String preOrderUserID) {
        Order preorder = findPreOrder(preOrderUserID);

        if(preorder == null || preorder.getCarID().equals("")){
            return null;
        } else {
            return preorder;
        }
    }

    public double getPreOrderPrice(ArrayList<Car> preOrderCars) {
        double price = 0;
        if(preOrderCars == null){
            return 0;
        } else {
            for (Car c : preOrderCars) {
                double oldprice = price;
                price = oldprice + c.getPrice();
            }
        }
        return price;
    }

    /*
    Called when logging by Logout if the answer was No
    Calls the orderhandler to delete that preorder with the users id
     */
    public void deletePreOrder(String userid) {
        int newUserID = Integer.parseInt(userid);
        dbOrder.deletePreOrder(newUserID);
    }

    public Order orderPurchased(String userID) {
        int newUserID = Integer.parseInt(userID);
        Order tempOrder = dbOrder.orderPurchased(newUserID);
        return tempOrder;
    }
}
