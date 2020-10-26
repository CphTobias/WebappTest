package com.tobias.function.api.facades;

import com.tobias.function.api.factories.OrderFactory;
import com.tobias.function.domain.Order;
import com.tobias.function.infrastructure.Database.DBOrder;
import com.tobias.function.domain.Car;

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

    public Order createOrder(int userID) {
        return dbOrder.createOrder(userID);
    }

    /*
    Called by AddToOrder. It parses the string to an integer and then calls the ordermapper to find a preorder
    returns either null or an order.
     */
    public Order findPreOrder(int userID) {
        return dbOrder.findPreOrder(userID);
    }

    /*
    Called by AddToOrder. It parses the string userID to and integer then calls the orderhandler to update the carid.
     */
    public void updatePreOrder(String carID, int userID) {
        try {
            dbOrder.updatePreOrder(carID, userID);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by AddToOrder. It parses the string userID to and integer then calls the orderhandler to update the carid.
     */
    public void updatePreOrder(String carIDs, String carID, int userID) {
        String newCarID = carIDs + carID;
        try {
            dbOrder.updatePreOrder(newCarID, userID);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    public Order getPreOrder(int userID) {
        Order preorder = findPreOrder(userID);
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
    public void deletePreOrder(int userid) {
        dbOrder.deletePreOrder(userid);
    }

    public Order orderPurchased(OrderFactory orderFactory) {
        Order order = findPreOrder(orderFactory.getUserID());
        return dbOrder.orderPurchased(orderFactory, order.getId());
    }
}
