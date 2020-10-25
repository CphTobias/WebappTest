package com.tobias.function.api.facades;

import com.tobias.function.api.factories.CarFactory;
import com.tobias.function.domain.Car;
import com.tobias.function.infrastructure.Database.DBCar;
import com.tobias.function.domain.Order;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CarFacade {

    private static CarFacade instance;

    private final DBCar dbCar;

    public CarFacade(DBCar dbCar) {
        this.dbCar = dbCar;
    }


    public static CarFacade getInstance() {
        if (instance == null) {
            instance = new CarFacade(new DBCar());
        }
        return instance;
    }

    /*
    Gets the objects from AddNewCar.
    It calls the CarHandler to which the creates a new car with the given objects.
     */
    public void createCar(CarFactory carFactory) {
        dbCar.createCar(carFactory);
    }


    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
    tring carid, String caravailable
     */
    public void setCarToClosed(CarFactory carFactory) {
        try {
            dbCar.setCarToClosed(carFactory.getId(), carFactory.isAvailable());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
     */
    public void updatePrice(CarFactory carFactory) {
        try {
            dbCar.updatePrice(carFactory.getId(), carFactory.getPrice());
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by AdminOptions (case "Manage Car Availability")
    It calls the CarMapper and returns a list of cars.
     */
    public List<Car> getAllCars() {
        return dbCar.getAllCars();
    }

    /*
    Called when logging in to find the pictures for the customer page
    It calls the CapMapper and returns a Car
     */
    public Car findCar(int carID) {
        return dbCar.findCar(carID);
    }

    public List<Car> findAvailableCars() {
        return dbCar.findAvailableCars();
    }

    public ArrayList<Car> getPreOrderCars(Order getPreOrder) {
        ArrayList<Car> carsInPreorder = new ArrayList<>();
        if(getPreOrder == null){
            return null;
        } else {
            String[] splitCars = getPreOrder.getCarID().split(",");
            int newS;

            for (String s : splitCars) {
                newS = Integer.parseInt(s);
                Car car = dbCar.findCar(newS);
                carsInPreorder.add(car);
            }
        }
        return carsInPreorder;
    }
}
