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
                throw new NoSuchElementException("No msg with id: " + id);
            }
        } catch (SQLException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

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
}
