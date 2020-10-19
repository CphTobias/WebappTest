package com.tobias.function.DBAcces.Mappers;

import com.tobias.function.DBAcces.DBSetup.Connector;
import com.tobias.function.function.entities.Car;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static com.tobias.function.DBAcces.DBSetup.Connector.getConnection;

public class CarMapper {

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
