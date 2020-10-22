package com.tobias.function.DBAcces.Database;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.Car;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class DBCar {

    /*
    Creates a car in the database with the objects given from LogicFacade createCar.
     */
    public Car createCar(int horsepower, String brand, double price, String category, String model, int weight, int buildyear,
                         int milage, String image){
        int id = 0;
        try (Connection conn = getConnection()) {
            var ps =
                    conn.prepareStatement(
                            "INSERT INTO cars (Horsepower, Brand, Price, Category, Model, Weight, BuildYear, Milage, Imagename) " +
                                    "VALUE (?,?,?,?,?,?,?,?,?);",
                            Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, horsepower);
            ps.setString(2, brand);
            ps.setDouble(3, price);
            ps.setString(4, category);
            ps.setString(5, model);
            ps.setInt(6, weight);
            ps.setInt(7, buildyear);
            ps.setInt(8, milage);
            ps.setString(9, image);
            ps.executeUpdate();

            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                id = rs.getInt(1);
            } else {
                System.out.println("Car does not exist throw");;
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return findCar(id);
    }

    /*
    Gets the id of a car and the current state of whether the car is closed or not, from LogicFacade setCarToClosed.
    It then either opens or closes the car.
     */
    public void setCarToClosed(int carID, boolean getCarBoolean) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            if(getCarBoolean == false){
                PreparedStatement ps2 = conn.prepareStatement(
                        "UPDATE cars SET available = 1 WHERE id = ?;");
                ps2.setInt(1, carID);
                ps2.executeUpdate();
                ps2.close();
            } else {
                PreparedStatement ps3 = conn.prepareStatement(
                        "UPDATE cars SET available = 0 WHERE id = ?;");
                ps3.setInt(1, carID);
                ps3.executeUpdate();
                ps3.close();
            }
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    /*
    Get the price and id from LogicFacade updatePrice
    It updates the price of a Car
     */
    public void updatePrice(int carID, double getCarPrice) throws SQLException, ClassNotFoundException {
        try(Connection conn = Connector.getConnection()) {
            PreparedStatement ps2 = conn.prepareStatement(
                    "UPDATE cars SET Price = ? WHERE id = ?;");
            ps2.setDouble(1, getCarPrice);
            ps2.setInt(2, carID);
            ps2.executeUpdate();
            ps2.close();
        } catch (SQLException | ClassNotFoundException se) {
            throw se;
        }
    }

    /*
    Is used to call from methods, where you want to get a car object.
     */
    private Car loadCar(ResultSet rs) throws SQLException {
        return new Car(
                rs.getInt("cars.id"),
                rs.getInt("cars.horsepower"),
                rs.getString("cars.brand"),
                rs.getDouble("cars.price"),
                rs.getString("cars.category"),
                rs.getString("cars.model"),
                rs.getInt("cars.weight"),
                rs.getInt("cars.buildyear"),
                rs.getInt("cars.milage"),
                rs.getString("cars.imagename"),
                rs.getBoolean("cars.available"));
    }

    /*
    Gets the id from LogicFacade findCar.
    It finds a specific car from the database with the given id.
     */
    public Car findCar(int id) throws NoSuchElementException {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cars WHERE id = ?;");
            s.setInt(1, id);
            ResultSet rs = s.executeQuery();
            if(rs.next()) {
                return loadCar(rs);
            } else {
                System.err.println("No version in properties.");
                throw new NoSuchElementException("No user with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /*
    Finds all the current cars in the database, is called from LogicFacade.
     */
    public List<Car> getAllCars() {
        try (Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement("SELECT * FROM cars;");
            ResultSet rs = s.executeQuery();
            ArrayList<Car> cars = new ArrayList<>();
            while(rs.next()) {
                cars.add(loadCar(rs));
            }
            return cars;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    public List<Car> findAvailableCars() {
        try(Connection conn = getConnection()) {
            PreparedStatement s = conn.prepareStatement(
                    "SELECT * FROM cars WHERE available = 1;");
            ResultSet rs = s.executeQuery();
            ArrayList<Car> cars = new ArrayList<>();
            while(rs.next()) {
                cars.add(loadCar(rs));
            }
            return cars;
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}