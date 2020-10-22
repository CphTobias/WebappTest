package com.tobias.function.function.layer;

import com.tobias.function.DBAcces.Database.DBCar;
import com.tobias.function.function.entities.Car;
import com.tobias.function.function.entities.Order;

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
    public void createCar(String horsepower, String brand, String price, String category, String model, String weight,
                          String buildYear, String milage, String image) {

        int newhorsepower = Integer.parseInt(horsepower);
        double newprice = Double.parseDouble(price);
        int newweight = Integer.parseInt(weight);
        int newbuildyear = Integer.parseInt(buildYear);
        int newmilage = Integer.parseInt(milage);

        dbCar.createCar(newhorsepower,brand, newprice, category, model, newweight, newbuildyear, newmilage, image);
    }


    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
     */
    public void setCarToClosed(String carid, String caravailable) {

        boolean getCarBoolean = Boolean.parseBoolean(caravailable);
        int getCarID = Integer.parseInt(carid);

        try {
            dbCar.setCarToClosed(getCarID, getCarBoolean);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by CarAvailable with the given objects.
    It calls the CarHandler with the parsed objects.
     */
    public void updatePrice(String carid, String newPrice) {

        int getCarID = Integer.parseInt(carid);
        double getNewPrice = Double.parseDouble(newPrice);

        try {
            dbCar.updatePrice(getCarID, getNewPrice);
        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }

    /*
    Called by AdminOptions (case "Manage Car Availability")
    It calls the CarMapper and returns a list of cars.
     */
    public List<Car> getAllCars() {
        List<Car> cars = dbCar.getAllCars();
        return cars;
    }

    /*
    Called when logging in to find the pictures for the customer page
    It calls the CapMapper and returns a Car
     */
    public Car findCar(int carID) {
        Car findcar = dbCar.findCar(carID);
        return findcar;
    }

    public List<Car> findAvailableCars() {
        List<Car> availableCars = dbCar.findAvailableCars();
        return availableCars;
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
